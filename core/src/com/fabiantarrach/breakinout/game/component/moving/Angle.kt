package com.fabiantarrach.breakinout.game.component.moving

import com.badlogic.gdx.math.Vector2

class Angle(degrees: Float) {

	private var degrees = degrees
		set(value) {
			if (value > 360)
				field = value - 360
			if (value < 0)
				field = value + 360
		}

	fun toVector(): Vector2 {
		return Vector2(1f, 0f).rotate(degrees)
	}

}