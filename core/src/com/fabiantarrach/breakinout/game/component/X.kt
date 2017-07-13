package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.game.component.rectangle.Width
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.Numerical

class X(value: Float) : Numerical(value) {
	operator fun plus(width: Width) = X(super.plus(width))
	operator fun minus(width: Width) = X(super.minus(width))
	operator fun compareTo(other: X) = super.compareTo(other)

	fun update(circle: GdxCircle) {
		circle.x = value
	}

	fun update(rectangle: GdxRectangle) {
		rectangle.x = value
	}
}




