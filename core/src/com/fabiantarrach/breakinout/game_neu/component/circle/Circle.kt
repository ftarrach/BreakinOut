package com.fabiantarrach.breakinout.game.component.circle

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.Position
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxIntersector
import com.fabiantarrach.breakinout.util.GdxShapeRenderer

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
		brush.color = Color.RED
		brush.circle(gdxCircle.x, gdxCircle.y, gdxCircle.radius)
	}

	private fun toGdxCircle() = position.createGdxCircle(radius)

}