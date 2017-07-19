package com.fabiantarrach.breakinout.util.math

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.circle.Radius
import com.fabiantarrach.breakinout.game.component.rectangle.Width
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxVector

// TODO basically all methods are the same in Y. Common interface with generics?
class X(value: Float) : Numerical(value) {
	operator fun plus(radius: Radius) = X(super.plus(radius))
	operator fun plus(width: Width) = X(super.plus(width))
	operator fun plus(x: X) = X(super.plus(x))
	operator fun minus(width: Width) = X(super.minus(width))
	operator fun minus(radius: Radius) = X(super.minus(radius))
	operator fun minus(x: X) = X(super.minus(x))
	operator fun times(factor: Factor) = X(super.times(factor))
	operator fun unaryMinus() = X(super.invert())
	operator fun compareTo(other: X) = super.compareTo(other)

	// TODO: I don't like the method name "update" here...
	fun update(circle: GdxCircle) {
		circle.x = value
	}

	fun update(rectangle: GdxRectangle) {
		rectangle.x = value
	}

	fun update(vector: GdxVector) {
		vector.x = value
	}

	fun crub() = createVectorial(Y(0f)) { x, y -> Velocity(x, y) }

	fun ifOutside(block: () -> Unit) {
		if (this < X(-1f) || this > X(1f))
			block()
	}

}