package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.Milliseconds

class Position(private var x: Float, private var y: Float) {

	fun moveBy(velocity: Velocity, delta: Milliseconds) {
		val frameVelocity = velocity.frameVelocity(delta)
		x += frameVelocity.xValue()
		y += frameVelocity.yValue()
	}

	fun xMinus(value: Float) = x - value
	fun xPlus(value: Float) = x + value
	fun yMinus(value: Float) = y - value
	fun yPlus(value: Float) = y + value

	@Deprecated("Setter") fun set(x: Float, y: Float) {
		this.x = x
		this.y = y
	}
}