package com.fabiantarrach.breakinout.util

import com.fabiantarrach.breakinout.util.engine.Timespan

abstract class Vectorial(x: Float, y: Float) {
	protected val vector = GdxVector(x, y)

	protected fun <T : Vectorial> plus(other: Vectorial, block: (Float, Float) -> T): T {
		val newX = vector.x + other.vector.x
		val newY = vector.y + other.vector.y
		return block(newX, newY)
	}

	protected fun <T : Vectorial> scale(other: Numerical, block: (Float, Float) -> T): T {
		val newVector = other.scale(vector)
		return block(newVector.x, newVector.y)
	}

}

class Velocity(x: Float, y: Float) : Vectorial(x, y) {

	fun normalize(time: Timespan) =
			scale(time) { x, y ->
				Velocity(x, y)
			}


}