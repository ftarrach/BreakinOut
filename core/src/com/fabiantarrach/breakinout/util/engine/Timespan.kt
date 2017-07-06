package com.fabiantarrach.breakinout.util.engine

class Timespan(private val millis: Float) {

	@Deprecated("takes primitve, returns primive")
	operator fun times(value: Float) = millis * value
}