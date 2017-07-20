package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.ifTrue
import com.fabiantarrach.breakinout.util.math.Y

class YAxis(private var y: Y,
            private var height: Height) {

	constructor(y: Float, height: Float) : this(Y(y), Height(height))

	fun ifOverlaps(other: YAxis, then: () -> Unit) {
		if (y < other.y + other.height && y + height > other.y)
			then()
	}

	fun update(rectangle: GdxRectangle) {
		y.update(rectangle)
		height.update(rectangle)
	}

	fun move(velocity: Velocity): YAxis {
		val y = velocity.move(y)
		return YAxis(y, height)
	}

	fun third(): YAxis = YAxis(y, height.third())

	private fun ifElse(check: () -> Boolean, then: () -> Unit, orElse: () -> Unit) {
		check().ifTrue(then, orElse)
	}

	fun ifUnder(other: Y, then: () -> Unit, ifNot: () -> Unit) {
		if (y > other) {
			then()
			return
		}
		ifNot()
	}

	fun ifSide(other: Y, then: () -> Unit, ifNot: () -> Unit) {
		if (y < other && y + height > other) {
			then()
			return
		}
		ifNot()
	}
}