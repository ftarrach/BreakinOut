package com.fabiantarrach.breakinout.game.component.euclid

class Dimension(private val width: Float, private val height: Float) : EuclidianSize {
	@Deprecated("Getter, returns primitive")
	fun width() = width
	@Deprecated("Getter, returns primitive")
	fun halfWidth() = width / 2
	@Deprecated("Getter, returns primitive")
	fun height() = height
	@Deprecated("Getter, returns primitive")
	fun halfHeight() = height / 2
}