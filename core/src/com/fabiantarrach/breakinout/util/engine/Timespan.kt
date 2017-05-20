package com.fabiantarrach.breakinout.util.engine

class Timespan(private val millis: Float) {

	operator fun times(value: Float) = millis * value
}