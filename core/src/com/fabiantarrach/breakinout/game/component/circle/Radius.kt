package com.fabiantarrach.breakinout.game.component.circle

import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.math.Numerical

class Radius(value: Float): Numerical(value) {
	fun update(circle: GdxCircle) {
		circle.radius = value
	}
}