package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.math.Factor
import com.fabiantarrach.breakinout.util.math.Numerical

class Width(value: Float) : Numerical(value) {

	init {
		if (value < 0)
			throw IllegalArgumentException("Width cannot be smaller than 0")
	}

	fun shorter(factor: Factor): Width {
		val newValue = super.times(factor)
		return Width(newValue)
	}

	fun wider(factor: Factor): Width {
		val newValue = super.times(factor)
		return Width(newValue)
	}

	fun differenceTo(other: Width): Width {
		val difference = super.difference(other)
		return Width(difference)
	}

	fun halve(): Width {
		val aHalf = Factor(0.5f)
		val halfValue = super.times(aHalf)
		return Width(halfValue)
	}

	fun update(rectangle: GdxRectangle) {
		rectangle.width = value
	}

}