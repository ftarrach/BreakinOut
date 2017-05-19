package com.fabiantarrach.breakinout.game.data

import com.badlogic.gdx.math.Vector2

class Angle(private val degrees: Float) {

	//	private fun cos() = MathUtils.cosDeg(degrees)
//	private fun sin() = MathUtils.sinDeg(degrees)
	fun vectorOf(speed: Speed) = Vector2(speed.floatValue(), 0f).rotate(degrees)!!

	operator fun Float.times(value: Speed) = this + value.floatValue()
	fun floatValue(): Float = degrees
}