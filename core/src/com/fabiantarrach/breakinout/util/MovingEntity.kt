package com.fabiantarrach.breakinout.util

import com.fabiantarrach.breakinout.game.component.Friction
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.util.engine.Timespan

abstract class MovingEntity(protected var velocity: Velocity = Velocity(0f, 0f), life: Int = 1) : Entity(life) {

	override fun update(delta: Timespan) {
		val normalizedVelocity = velocity * delta
		shape.move(normalizedVelocity)
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

	protected fun scrub(other: MovingEntity) {
		val friction = Friction(0.8f)
		val scrubVelocity = velocity.cease(friction)
		other.push(scrubVelocity)
	}

}