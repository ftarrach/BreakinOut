package com.fabiantarrach.breakinout.util.math

import com.fabiantarrach.breakinout.game.component.circle.Radius
import com.fabiantarrach.breakinout.game.component.rectangle.Height
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxVector

class Y(value: Float) : Numerical(value) {
	operator fun plus(radius: Radius) = Y(super.plus(radius))
	operator fun plus(height: Height) = Y(super.plus(height))
	operator fun plus(y: Y) = Y(super.plus(y))
	operator fun minus(y: Y) = Y(super.minus(y))
	operator fun minus(radius: Radius) = Y(super.minus(radius))
	operator fun compareTo(other: Y) = super.compareTo(other) // TODO: this returns a int/boolean => primitve
	operator fun times(factor: Factor) = Y(super.times(factor))
	operator fun unaryMinus() = Y(super.invert())

	fun update(circle: GdxCircle) {
		circle.y = value
	}

	fun update(rectangle: GdxRectangle) {
		rectangle.y = value
	}

	fun update(vector: GdxVector) {
		vector.y = value
	}

	override public fun ifNegative(then: () -> Unit) = super.ifNegative(then)

	fun ifOutside(block: () -> Unit) {
		if (this < Y(-1f) || this > Y(1f))
			block()
	}

}