package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.math.Numerical

class Height(value: Float) : Numerical(value) {

	init {
		if (value < 0)
			throw IllegalArgumentException("Height cannot be smaller than 0")
	}

	fun update(rectangle: GdxRectangle) {
		rectangle.height = value
	}

	fun third() = oneThird(::Height)
}