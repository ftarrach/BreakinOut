package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.math.Numerical
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y

class Angle(value: Float) : Numerical(value) {

	fun rotateX(x: X) = RotatedX(X(times(x)))
	fun rotateY(y: Y) = RotatedY(Y(times(y)))

}
