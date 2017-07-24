package com.fabiantarrach.breakinout.util.math

import com.fabiantarrach.breakinout.util.GdxVector
import com.fabiantarrach.breakinout.util.accept
import com.fabiantarrach.breakinout.util.ifTrue

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

	protected fun <T : Numerical> halve(block: (Float) -> T) = block(value / 2)
	protected fun <T : Numerical> oneThird(block: (Float) -> T) = block(value / 3)

	protected fun ifSmaller(other: Numerical, then: () -> Unit, orElse: () -> Unit = {}) =
			(value < other.value)
					.accept(then, orElse)

	protected fun ifBigger(other: Numerical, then: () -> Unit, orElse: () -> Unit = {}) =
			(value > other.value)
					.accept(then, orElse)

	protected fun difference(other: Numerical): Float {
		if (value >= other.value)
			return value - other.value
		return other.value - value
	}

	protected fun <T : Vectorial> createVectorial(other: Numerical, block: (Float, Float) -> T) = block(value, other.value)

	protected open fun ifNegative(then: () -> Unit) =
			(value < 0)
					.ifTrue(then)

	protected open fun ifPositive(then: () -> Unit) =
			(value > 0)
					.ifTrue(then)

	override fun toString(): String {
		return "$value"
	}

	override fun equals(other: Any?): Boolean {
		if (other != null && other is Numerical && other.javaClass == this.javaClass)
			return value == other.value
		return false
	}

	override fun hashCode(): Int = value.hashCode()
}