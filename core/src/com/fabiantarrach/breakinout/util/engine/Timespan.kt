package com.fabiantarrach.breakinout.util.engine

class Timespan(private val millis: Float) {

	fun <T> normalize(x: Float, y: Float, block: (Float, Float) -> T): T {
		val newX = x * millis
		val newY = y * millis
		return block(newX, newY)
	}

}