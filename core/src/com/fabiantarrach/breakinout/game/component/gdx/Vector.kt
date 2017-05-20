package com.fabiantarrach.breakinout.game.component.gdx

import com.fabiantarrach.breakinout.game.component.moving.Angle
import com.badlogic.gdx.math.Vector2 as GdxVector

class Vector(len: Float, angle: Angle) {

	private val gdxVector = GdxVector(len, 0f).rotate(angle.toVector().angle())

	fun angle() = Angle(gdxVector.angle())

	@Deprecated("return primitive")
	fun length() = gdxVector.len()

	@Deprecated("returns primitive")
	fun xValue() = gdxVector.x

	@Deprecated("returns primitive")
	fun yValue() = gdxVector.y

}