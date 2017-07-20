package com.fabiantarrach.breakinout.game.component

import com.badlogic.gdx.math.Vector2
import com.fabiantarrach.breakinout.util.GdxVector
import com.fabiantarrach.breakinout.util.math.Numerical

class Angle(degrees: Float) : Numerical(degrees) {

	fun rotate(vector: GdxVector): Vector2 {
		val copy = vector.cpy()
		copy.rotate(value)
		return copy
	}

}
