package com.fabiantarrach.breakinout.game.entity_v2.component.euclid

import com.badlogic.gdx.math.Rectangle as GdxRectangle

class Position(private var x: Float, private var y: Float) {
	fun xCoordinate() = Coordinate(x)
	fun yCoordinate() = Coordinate(y)
}

class Coordinate(private val value: Float) {
	@Deprecated("getter, returns primitive")
	fun floatValue() = value

	@Deprecated("getter, returns primitive")
	fun intValue() = value.toInt()

	operator fun compareTo(other: Coordinate): Int = value.compareTo(other.value)
}
