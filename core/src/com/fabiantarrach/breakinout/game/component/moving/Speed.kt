package com.fabiantarrach.breakinout.game.component.moving

import com.fabiantarrach.breakinout.util.engine.Timespan

class Speed(private var speed: Float) {

	fun normalize(delta: Timespan) = Speed(delta * speed)

	fun faster() {
		speed += 5
	}

	fun slower() {
		speed -= 5
	}

	fun toFloat() = speed
}
