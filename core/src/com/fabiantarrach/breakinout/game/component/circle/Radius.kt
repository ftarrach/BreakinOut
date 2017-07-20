package com.fabiantarrach.breakinout.game.component.circle

import com.fabiantarrach.breakinout.game.component.rectangle.Height
import com.fabiantarrach.breakinout.game.component.rectangle.Width
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.math.Numerical

class Radius(value: Float) : Numerical(value) {
	fun update(circle: GdxCircle) {
		circle.radius = value
	}

	fun circleWidth() = Width(value * 2)
	fun circleHeight() = Height(value * 2)
}
