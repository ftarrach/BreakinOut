package com.fabiantarrach.breakinout.util.math

import com.fabiantarrach.breakinout.game.component.circle.Radius
import com.fabiantarrach.breakinout.game.component.rectangle.Width
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxVector

class X(value: Float) : Numerical(value) {

	operator fun plus(radius: Radius) = X(super.plus(radius))
	operator fun plus(width: Width) = X(super.plus(width))
	operator fun plus(x: X) = X(super.plus(x))
	operator fun minus(width: Width) = X(super.minus(width))
	operator fun minus(radius: Radius) = X(super.minus(radius))
	operator fun minus(x: X) = X(super.minus(x))
	operator fun times(factor: Factor) = X(super.times(factor))
	operator fun div(width: Width) = X(super.div(width))
	operator fun unaryMinus() = X(super.invert())
	// TODO: this returns a int/boolean => primitve
//	operator fun compareTo(other: X) = super.compareTo(other)

	fun ifRightOf(other: X, then: () -> Unit, orElse: () -> Unit = {}) =
			ifBigger(other, then, orElse)

	fun ifLeftOf(other: X, then: () -> Unit, orElse: () -> Unit = {}) =
			ifSmaller(other, then, orElse)

	fun update(circle: GdxCircle) {
		circle.x = value
	}

	fun update(rectangle: GdxRectangle) {
		rectangle.x = value
	}

	fun update(vector: GdxVector) {
		vector.x = value
	}

	public override fun ifNegative(then: () -> Unit) = super.ifNegative(then)
	public override fun ifPositive(then: () -> Unit) = super.ifPositive(then)

	fun ifOutside(then: () -> Unit) =
			ifLeftOf(X(-1f), then, orElse = {
				this.ifRightOf(X(1f), then)
			})

	fun double() = X(value * 2f)

}