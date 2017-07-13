package com.fabiantarrach.breakinout.util

// TODO: to private val value?
abstract class Numerical(protected val value: Float) {

	operator fun times(vector: GdxVector): GdxVector {
		val scaled = vector.cpy()
		scaled.scl(value)
		return scaled
	}

	protected operator fun plus(other: Numerical) = value + other.value
	protected operator fun minus(other: Numerical) = value - other.value
	protected operator fun times(other: Numerical) = value * other.value
	protected operator fun div(other: Numerical) = value / other.value

	fun scale(vector: GdxVector) = GdxVector(value * vector.x, value * vector.y)

	// do i need this..?
	protected operator fun compareTo(other: Numerical) = value.compareTo(other.value)

	protected fun difference(other: Numerical): Float {
		if (value >= other.value)
			return value - other.value
		return other.value - value
	}

}