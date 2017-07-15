package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.circle.Circle
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.Timespan

class Ball(x: Float, y: Float) : Entity() {
	override val shape = Circle(x, y, 0.025f)
	private var velocity = Velocity(0f, -0.5f)

	override fun update(delta: Timespan) {
		val normalizedVelocity = velocity.normalize(delta)
		shape.move(normalizedVelocity)
	}

	override fun render(renderer: GdxShapeRenderer) = shape.render(renderer, GdxColor.RED)

	fun ifMovingDown(then: () -> Unit) = velocity.ifMovingDown(then)

	fun bounceOff() {
		// TODO: pass metadata of the collision etc
		velocity = velocity.invertHorizontal()
	}

	fun  moveRandom() {
		velocity = velocity.randomizeAngle()
	}

}