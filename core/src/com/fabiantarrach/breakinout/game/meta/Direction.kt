package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.game.component.circle.Radius
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y

enum class Direction {
	LEFT, RIGHT, TOP, BOTTOM;

	fun keepInside(x: X, radius: Radius): X {
		if (this == LEFT)
			return x + radius
		if (this == RIGHT)
			return x - radius
		return x
	}

	fun keepInside(y: Y, radius: Radius): Y {
		if (this == TOP)
			return y - radius
		if (this == BOTTOM)
			return y + radius
		return y
	}
}