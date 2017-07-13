package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.game.component.numeric.Numerical
import com.fabiantarrach.breakinout.util.GdxRectangle

class Height(value: Float) : Numerical(value) {init {
	if (value < 0)
		throw IllegalArgumentException("width cannot be smaller than 0")
	}

	fun update(rectangle: GdxRectangle) {
		rectangle.height = value
	}
}