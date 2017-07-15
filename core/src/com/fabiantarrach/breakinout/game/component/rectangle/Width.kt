package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.game.component.Factor
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.Numerical

class Width(value: Float) : Numerical(value) {

	init {
		if ( value < 0)
			throw IllegalArgumentException("width cannot be smaller than 0")
	}

	fun shorter(factor: Factor) = Width(super.times(factor))
	fun wider(factor: Factor) = Width(super.times(factor))
	fun difference(other: Width) = Width(super.difference(other))

	fun halve() = Width(value / 2)

	fun update(rectangle: GdxRectangle) {
		rectangle.width = value
	}

	fun crub() = Velocity(value, 0f)
}