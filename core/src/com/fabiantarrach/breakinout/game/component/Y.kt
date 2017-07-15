package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.game.component.rectangle.Height
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.Numerical

class Y(value: Float) : Numerical(value) {
	operator fun plus(width: Height) = Y(super.plus(width))
	operator fun plus(y: Y) = Y(super.plus(y))
	operator fun compareTo(other: Y) = super.compareTo(other)

	fun update(circle: GdxCircle) {
		circle.y = value
	}

	fun update(rectangle: GdxRectangle) {
		rectangle.y = value
	}
}