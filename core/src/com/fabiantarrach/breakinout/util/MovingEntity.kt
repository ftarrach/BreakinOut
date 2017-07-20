package com.fabiantarrach.breakinout.util

import com.fabiantarrach.breakinout.game.component.Friction
import com.fabiantarrach.breakinout.game.component.MousePosition
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.util.engine.Timespan

abstract class MovingEntity(private var velocity: Velocity = Velocity(0f, 0f), life: Int = 1) : Entity(life) {

	private var lastTimespan: Timespan = Timespan(0f)

	override fun update(delta: Timespan) {
		val normalizedVelocity = velocity * delta
		shape.move(normalizedVelocity)
		lastTimespan = delta
	}

	protected open fun bounceOffFront() {
		velocity = velocity.deflectFront()
	}

	protected open fun bounceOffSide() {
		velocity = velocity.deflectSide()
	}

	protected open fun moveRandom() {
		velocity = velocity.randomizeAngle()
	}

	protected fun push(push: Velocity) {
		velocity = velocity.push(push)
	}

	protected open fun moveTo(mouse: MousePosition) {
		velocity = mouse.velocityTo(shape)
	}

	protected fun scrub(other: MovingEntity) {
		val friction = Friction(0.8f)
		val scrubVelocity = velocity.cease(friction)
		other.push(scrubVelocity)
	}

	protected open fun revertLastMove() {
		val inverted = velocity.invert()
		shape.move(inverted * lastTimespan)
	}

	protected open fun bat(other: MovingEntity) = other.slamX(velocity)

	protected open fun slamX(other: Velocity) {
		shape.move(other * lastTimespan)
		velocity += other
	}

	fun ifMovingDown(then: () -> Unit) = velocity.ifMovingDown(then)
	fun ifMovingRight(then: () -> Unit) = velocity.ifMovingRight(then)

}