package com.fabiantarrach.breakinout.game.component.euclid

interface EuclidianSize

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

class CircleSize(private val radius: Float) : EuclidianSize {
	@Deprecated("Getter, returns primitive")
	fun radius() = radius
	@Deprecated("Getter, returns primitive")
	fun diameter() = radius * 2
}
