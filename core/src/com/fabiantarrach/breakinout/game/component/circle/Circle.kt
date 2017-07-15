package com.fabiantarrach.breakinout.game.component.circle

import com.fabiantarrach.breakinout.game.component.Position
import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxIntersector
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.circle

class Circle(x: Float, y: Float, radius: Float): Shape() {
	private var position = Position(x, y)
	private val radius = Radius(radius)

	override fun ifOverlaps(other: Shape, then: () -> Unit) {
		if (other is Rectangle)
			ifOverlaps(other, then)
	}

	private fun ifOverlaps(rectangle: Rectangle, then: () -> Unit) {
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

	override fun ifUnder(other: Shape, then: () -> Unit, ifNot: () -> Unit) {
		// TODO: implement ifUnder
	}

	fun ifOutsideGame(left: () -> Unit, right: () -> Unit, top: () -> Unit, bottom: () -> Unit) {
//		if (vector.x - vector.radius < -1) left()
//		if (vector.x + vector.radius > 1) right()
//		if (vector.y + vector.radius > 1) top()
//		if (vector.y + vector.radius < -1) bottom()
	}

//
//	fun keepInsideGame() {
//		if (vector.x - vector.radius < -1) vector.x = -1 + vector.radius
//		if (vector.x + vector.radius > 1) vector.x = 1 - vector.radius
//		if (vector.y + vector.radius > 1) vector.y = 1 - vector.radius
//		if (vector.y + vector.radius < -1) vector.y = -1 + vector.radius
//	}
}