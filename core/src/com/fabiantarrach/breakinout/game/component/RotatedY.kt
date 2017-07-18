package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.math.Numerical
import com.fabiantarrach.breakinout.util.math.Y

class RotatedY(y: Y) : Numerical(y) {
	fun resolve(rotatedX: RotatedX): Y = Y(plus(rotatedX))
}