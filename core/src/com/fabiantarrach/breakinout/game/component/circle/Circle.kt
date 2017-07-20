package com.fabiantarrach.breakinout.game.component.circle

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxIntersector
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.circle
import com.fabiantarrach.breakinout.util.math.X

class Circle(x: Float, y: Float, radius: Float) : Shape() {
	private var position = CirclePosition(x, y)
	private val radius = Radius(radius)

	override fun ifOverlaps(other: Shape, then: () -> Unit) {
		if (other is Rectangle)
			ifOverlaps(other, then)
	}

	private fun ifOverlaps(rectangle: Rectangle, then: () -> Unit) {
		val gdxCircle = toGdxCircle()
		val gdxRectangle = rectangle.createGdx()
		if (GdxIntersector.overlaps(gdxCircle, gdxRectangle))
			then()
	}

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
		if (shape is Circle)
			return position.relativeTo(shape.position)
		throw IllegalArgumentException("relativeTo between Circle and ${shape::javaClass} is not yet implemented")
	}

	override fun relativeTo(x: X) = position.relativeTo(x)

	private fun toGdxCircle() = position.createGdxCircle(radius)

	override fun ifNextTo(other: Shape, then: () -> Unit, ifNot: () -> Unit) {
		if (other is Rectangle)
			return position.ifNextTo(other, then, ifNot)
		// TODO: next to circle?
		throw IllegalArgumentException("ifNextTo between Circle and ${other::javaClass} is not yet implemented")
	}

	override fun ifUnder(other: Shape, then: () -> Unit, ifNot: () -> Unit) {
		if (other is Rectangle)
			return position.ifUnder(other, then, ifNot)
		if (other is Circle)
			return position.ifUnder(other.position, then, ifNot)
		throw IllegalArgumentException("ifUnder between Circle and ${other::javaClass} is not yet implemented")
	}

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