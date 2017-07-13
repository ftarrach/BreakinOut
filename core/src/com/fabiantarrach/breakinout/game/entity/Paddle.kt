package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.Timespan

class Paddle(x: Float, y: Float) : Entity() {

	private val rectangle = Rectangle(0f, -0.8f, 0.2f, 0.05f)

	override fun update(delta: Timespan) {
//		TODO("not implemented")
	}

	override fun render(renderer: GdxShapeRenderer) {
		rectangle.render(renderer, GdxColor.WHITE)
	}

}