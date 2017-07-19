package com.fabiantarrach.breakinout.game.component.circle

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.math.Vectorial
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y

class CirclePosition(x: X, y: Y) : Vectorial(x, y) {

	constructor(x: Float, y: Float) : this(X(x),
			Y(y))

	fun createGdxCircle(radius: Radius): GdxCircle {
		val circle = GdxCircle()
		x.update(circle)
		y.update(circle)
		radius.update(circle)
		return circle
	}

	fun ifLeftOutside(radius: Radius, block: () -> Unit) = (x - radius).ifOutside(block)
	fun ifRightOutside(radius: Radius, block: () -> Unit) = (x + radius).ifOutside(block)
	fun ifTopOutside(radius: Radius, block: () -> Unit) = (y + radius).ifOutside(block)
	fun ifBottomOutside(radius: Radius, block: () -> Unit) = (y - radius).ifOutside(block)

	fun move(velocity: Velocity): CirclePosition {
		val newX = velocity.move(x)
		val newY = velocity.move(y)
		return CirclePosition(newX, newY)
	}

	fun keepInside(radius: Radius): CirclePosition {
		var newX = x
		var newY = y
		ifLeftOutside(radius) {
			newX = x + radius
		}
		ifRightOutside(radius) {
			newX = x - radius
		}
		ifTopOutside(radius) {
			newY = y - radius
		}
		ifBottomOutside(radius) {
			newY = y + radius
		}
		return CirclePosition(newX, newY)
	}

	fun ifOver(rectangle: Rectangle, then: () -> Unit, ifNot: () -> Unit) = rectangle.ifNextToOrUnder(y, then, ifNot)
}