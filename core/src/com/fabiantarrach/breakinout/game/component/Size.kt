package com.fabiantarrach.breakinout.game.component

sealed class Size(private var width: Float, private var height: Float) {

	fun width() = width
	fun height() = height
	fun halfWidth() = width / 2
	fun halfHeight() = height / 2

	class CircleSize(diameter: Float) : Size(diameter, diameter)
	class RectangleSize(width: Float, height: Float) : Size(width, height)
}
