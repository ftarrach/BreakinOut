package com.fabiantarrach.breakinout.game.component.moving

import com.fabiantarrach.breakinout.game.component.gdx.Vector
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.badlogic.gdx.math.Vector2 as GdxVector

class Velocity private constructor(private val vector: Vector) {

	constructor(speed: Speed, angle: Angle) : this(Vector(speed.toFloat(), angle))

	constructor(x: Float, y: Float) : this(Vector(x, y))

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