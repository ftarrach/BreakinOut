package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.game.component.Friction
import com.fabiantarrach.breakinout.game.component.MousePosition
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.util.engine.Timespan

abstract class MovingEntity(protected var velocity: Velocity = Velocity(0f, 0f),
                            life: Int = 1) : BaseEntity(life) {

	private var lastTimespan: Timespan = Timespan(0f)

	override fun update(delta: Timespan) {
		val frameVelocity = velocity * delta
		shape.move(frameVelocity)
		lastTimespan = delta
	}

	protected open fun bounceOffFront() {
		undoLastMovement()
		velocity = velocity.deflectFront()
	}

	protected open fun bounceOffSide() {
		undoLastMovement()
		velocity = velocity.deflectSide()
	}

	protected fun push(push: Velocity) {
		velocity = velocity.push(push)
	}

	protected open fun moveTo(mouse: MousePosition) {
		velocity = mouse.velocityTo(shape)
	}

	protected fun scrub(other: MovingEntity, friction: Friction) {
		val scrubVelocity = velocity.cease(friction)
		other.push(scrubVelocity)
	}

	protected open fun undoLastMovement() {
		val inverted = velocity.invert()
		shape.move(inverted * lastTimespan)
	}

	protected open fun bat(other: MovingEntity) = other.slamX(velocity)

	protected open fun slamX(other: Velocity) {
		shape.move(other * lastTimespan)
		velocity = velocity.slam(other)
	}

	fun ifMovingDown(then: () -> Unit) = velocity.ifMovingDown(then)
	fun ifMovingRight(then: () -> Unit) = velocity.ifMovingRight(then)
}