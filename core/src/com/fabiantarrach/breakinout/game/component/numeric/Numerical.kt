package com.fabiantarrach.breakinout.game.component.numeric

import com.fabiantarrach.breakinout.util.GdxVector

// TODO: to private val value?
abstract class Numerical(protected val value: Float) {

	operator fun times(vector: GdxVector): GdxVector {
		val scaled = vector.cpy()
		scaled.scl(value)
		return scaled
	}

	protected fun ifSmaller(other: Numerical, block: () -> Unit) {
		if (value < other.value)
			block()
	}

}