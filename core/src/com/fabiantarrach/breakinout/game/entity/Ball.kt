package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.circle.Circle
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.Velocity
import com.fabiantarrach.breakinout.util.engine.Timespan

class Ball(x: Float, y: Float) : Entity() {

	private val circle = Circle(x, y, 0.025f)
	private var velocity = Velocity(0f, -1f)

	override fun update(delta: Timespan) {
		val normalizedVelocity = velocity.normalize(delta)
		circle.move(normalizedVelocity)
	}

	override fun render(renderer: GdxShapeRenderer) {
		circle.render(renderer, GdxColor.RED)
	}

}