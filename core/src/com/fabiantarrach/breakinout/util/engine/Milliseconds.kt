package com.fabiantarrach.breakinout.util

class Milliseconds(private val millis: Float) {
	operator fun times(value: Float) = millis * value
	@Deprecated("Getter?") fun floatValue() = millis
}