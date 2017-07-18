package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.math.Numerical
import com.fabiantarrach.breakinout.util.math.X

class RotatedX(x: X): Numerical(x) {
	fun resolve(y: RotatedY): X = X(minus(y))

}