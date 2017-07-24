package com.fabiantarrach.breakinout.game.component.circle

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.meta.Intersection
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.circle
import com.fabiantarrach.breakinout.util.math.X

class Circle(x: Float, y: Float, radius: Float) : Shape() {
	private var position = CirclePosition(x, y)
	private val radius = Radius(radius)

	fun ifOverlaps(rectangle: Rectangle, then: () -> Unit) =
			Intersection(
					toGdxCircle(),
					rectangle.createGdx()
			).ifOverlaps(then)

	override fun render(renderer: GdxShapeRenderer, color: GdxColor) {
		val gdxCircle = toGdxCircle()
		renderer.circle(gdxCircle, color)
	}

	override fun move(velocity: Velocity) {
		position = position.move(velocity)
	}

	override fun relativeTo(shape: Shape): X {
		if (shape is Rectangle)
			return position.relativeTo(shape)
		throw IllegalArgumentException("relativeTo between Circle and ${shape::javaClass} is not yet implemented")
	}

	override fun relativeTo(x: X) = position.relativeTo(x)

	private fun toGdxCircle() = position.createGdxCircle(radius)

	fun ifNextTo(other: Rectangle, then: () -> Unit, orElse: () -> Unit) =
			position.ifNextTo(other, then, orElse)

	fun ifUnder(other: Rectangle, then: () -> Unit, orElse: () -> Unit) =
			position.ifUnder(other, then, orElse)

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