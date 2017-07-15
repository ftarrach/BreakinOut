package com.fabiantarrach.breakinout.util

import com.fabiantarrach.breakinout.game.component.Vectorial

// TODO: is protected because of GdxRectangle and GdxCircle
abstract class Numerical(protected val value: Float) {

	protected operator fun times(vector: GdxVector): GdxVector {
		val scaled = vector.cpy()
		scaled.scl(value)
		return scaled
	}

	protected operator fun plus(other: Numerical) = value + other.value
	protected operator fun minus(other: Numerical) = value - other.value
	protected operator fun times(other: Numerical) = value * other.value
	protected operator fun div(other: Numerical) = value / other.value
	protected operator fun unaryMinus() = -value

	protected open fun <T: Numerical> oneThird(block: (Float) -> T) = block(value / 3)

	// do i need this..?
	protected operator fun compareTo(other: Numerical) = value.compareTo(other.value)

	protected fun difference(other: Numerical): Float {
		if (value >= other.value)
			return value - other.value
		return other.value - value
	}

	protected fun <T: Vectorial> createVectorial(other: Numerical, block: (Float, Float) -> T) = block(value, other.value)

	fun ifNegative(then: () -> Unit) {
		if (value < 0)
			then()
	}

}