package com.fabiantarrach.breakinout.game.component.moving

import com.fabiantarrach.breakinout.game.component.gdx.Vector
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.badlogic.gdx.math.Vector2 as GdxVector

class Velocity(speed: Speed, angle: Angle) {

	private val vector = Vector(speed.toFloat(), angle)

	operator fun times(delta: Timespan): Velocity =
		Velocity(Speed(delta * vector.length()), vector.angle())

	@Deprecated("returns primitive")
	fun xValueAsFloat() = vector.xValue()

	@Deprecated("returns primitive")
	fun yValueAsFloat() = vector.yValue()

	fun invertHorizontal() {
		vector.invertHorizontal()
	}

}

class Angle(degrees: Float) {

	private var degrees = degrees
		set(value) {
			if (value > 360)
				field = value - 360
			if (value < 0)
				field = value + 360
		}

	fun toVector(): GdxVector {
		return GdxVector(1f, 0f).rotate(degrees)
	}

}