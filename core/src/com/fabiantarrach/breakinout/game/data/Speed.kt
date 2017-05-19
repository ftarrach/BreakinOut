package com.fabiantarrach.breakinout.game.data

class Speed(private var speed: Float) {
	fun floatValue(): Float = speed
	@Deprecated("Setter") fun set(speed: Float) {this.speed = speed}
	operator fun times(value: Float): Speed = Speed(speed * value)
	operator fun plus(value: Speed): Speed = Speed(speed + value.floatValue())
	operator fun minus(value: Speed): Speed = Speed(speed - value.floatValue())
}