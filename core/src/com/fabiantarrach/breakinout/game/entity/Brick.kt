package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.Timespan

class Brick(x: Float, y: Float, lifepoints: Int) : Entity(lifepoints) {

	private val rectangle = Rectangle(x, y, 0.2f, 0.1f)

	override fun update(delta: Timespan) {}

	override fun render(renderer: GdxShapeRenderer) {
		val color = createColor(Color.GRAY)
		rectangle.render(renderer, color)
	}

}