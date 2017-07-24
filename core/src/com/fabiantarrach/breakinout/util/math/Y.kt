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
	operator fun times(factor: Factor) = Y(super.times(factor))
	operator fun unaryMinus() = Y(super.invert())

	fun ifOver(other: Y, then: () -> Unit, orElse: () -> Unit = {}) =
			ifBigger(other, then, orElse)

	fun ifUnder(other: Y, then: () -> Unit, orElse: () -> Unit = {}) =
			ifSmaller(other, then, orElse)

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
	override public fun ifPositive(then: () -> Unit) = super.ifPositive(then)

	fun ifOutside(then: () -> Unit) =
			ifUnder(Y(-1f), then, orElse = {
				this.ifOver(Y(1f), then)
			})
}