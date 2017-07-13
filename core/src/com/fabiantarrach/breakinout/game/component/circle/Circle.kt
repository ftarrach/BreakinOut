package com.fabiantarrach.breakinout.game.component.circle

import com.fabiantarrach.breakinout.game.component.Position
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.*

class Circle(x: Float, y: Float, radius: Float) {
	private var position = Position(x, y)
	private val radius = Radius(radius)

	fun overlaps(rectangle: Rectangle, then: () -> Unit) {
		if (GdxIntersector.overlaps(
				toGdxCircle(),
				rectangle.createGdx()
		)) then()
	}

	fun render(brush: GdxShapeRenderer, color: GdxColor) {
		val gdxCircle = toGdxCircle()
		brush.circle(gdxCircle, color)
	}

	fun move(velocity: Velocity) {
		position = position.move(velocity)
	}

	private fun toGdxCircle() = position.createGdxCircle(radius)

}