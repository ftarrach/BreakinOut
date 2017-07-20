package com.fabiantarrach.breakinout.util.math

import com.badlogic.gdx.math.MathUtils
import com.fabiantarrach.breakinout.util.GdxVector

// TODO: value is protected because of GdxRectangle and GdxCircle
abstract class Numerical(protected val value: Float) {

	protected operator fun times(vector: GdxVector): GdxVector {
		val scaled = vector.cpy()
		scaled.scl(value)
		return scaled
	}

	protected operator fun plus(other: Numerical) = value + other.value
	protected operator fun minus(other: Numerical) = value - other.value
	protected fun times(other: Numerical) = value * other.value
	protected operator fun div(other: Numerical) = value / other.value
	protected fun invert() = -value

	// TODO: stupid method names. new class sin/cos holding value and just use the times(Numerical) method
	protected fun timesCos(other: Numerical) = MathUtils.cosDeg(value) * other.value

	protected fun timesSin(other: Numerical) = MathUtils.sinDeg(value) * other.value
	protected fun atan(x: Numerical, y: Numerical): Float = MathUtils.atan2(y.value, x.value) * MathUtils.radiansToDegrees

	protected fun <T : Numerical> halve(block: (Float) -> T) = block(value / 2)
	protected fun <T : Numerical> oneThird(block: (Float) -> T) = block(value / 3)

	// do i need this..?
	protected operator fun compareTo(other: Numerical) = value.compareTo(other.value)

	protected fun difference(other: Numerical): Float {
		if (value >= other.value)
			return value - other.value
		return other.value - value
	}

	protected fun <T : Vectorial> createVectorial(other: Numerical, block: (Float, Float) -> T) = block(value, other.value)

	protected open fun ifNegative(then: () -> Unit) {
		if (value < 0)
			then()
	}

	protected open fun ifPositive(then: () -> Unit) {
		if (value > 0)
			then()
	}

	override fun toString(): String {
		return "$value"
	}

}