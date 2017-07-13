package com.fabiantarrach.breakinout.game.component.circle

import com.fabiantarrach.breakinout.util.Numerical
import com.fabiantarrach.breakinout.util.GdxCircle

class Radius(value: Float): Numerical(value) {
	fun update(circle: GdxCircle) {
		circle.radius = value
	}
}