package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.util.Numerical

class Timespan(millis: Float): Numerical(millis) {

	@Deprecated("using primitives", ReplaceWith("think about it..."))
	fun <T> normalize(x: Float, y: Float, block: (Float, Float) -> T): T {
		val newX = x * value
		val newY = y * value
		return block(newX, newY)
	}

}