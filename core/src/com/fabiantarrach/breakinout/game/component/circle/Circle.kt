package com.fabiantarrach.breakinout.game_neu.component.circle

import com.fabiantarrach.breakinout.game_neu.component.Position
import com.fabiantarrach.breakinout.game_neu.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxIntersector
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.circle

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

	private fun toGdxCircle() = position.createGdxCircle(radius)

}