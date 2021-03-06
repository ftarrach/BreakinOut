package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.math.Vectorial
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y

class MousePosition(x: X, y: Y) : Vectorial(x, y) {

	constructor(x: Float, y: Float) : this(
			X(x),
			Y(y))

	fun velocityTo(shape: Shape): Velocity {
		val x = shape.relativeTo(x)
		return Velocity(x, Y(0f))
	}

}
