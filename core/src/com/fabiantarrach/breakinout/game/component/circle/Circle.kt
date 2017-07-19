package com.fabiantarrach.breakinout.game.component.circle

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxIntersector
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.circle

class Circle(x: Float, y: Float, radius: Float) : Shape() {
	private var position = CirclePosition(x, y)
	private val radius = Radius(radius)

	override fun ifOverlaps(other: Shape, then: () -> Unit) {
		if (other is Rectangle)
			ifOverlaps(other, then)
	}

	private fun ifOverlaps(rectangle: Rectangle, then: () -> Unit) {
		val gdxRectangle = rectangle.createGdx()
		if (GdxIntersector.overlaps(
				toGdxCircle(),
				gdxRectangle
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
		if (other is Rectangle)
			ifUnderRectangle(other, then, ifNot)
	}

	private fun ifUnderRectangle(rectangle: Rectangle, then: () -> Unit, ifNot: () -> Unit) =
			position.ifOver(rectangle, then, ifNot)

	fun ifOutsideGame(left: () -> Unit, right: () -> Unit, top: () -> Unit, bottom: () -> Unit) {
		position.ifLeftOutside(radius) {
			position = position.keepInside(radius)
			left()
		}
		position.ifRightOutside(radius) {
			position = position.keepInside(radius)
			right()
		}
		position.ifTopOutside(radius) {
			position = position.keepInside(radius)
			top()
		}
		position.ifBottomOutside(radius) {
			position = position.keepInside(radius)
			bottom()
		}
	}
}