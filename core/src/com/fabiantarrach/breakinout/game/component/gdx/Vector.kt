package com.fabiantarrach.breakinout.game.component.gdx

import com.fabiantarrach.breakinout.game.component.moving.Angle
import com.badlogic.gdx.math.Vector2 as GdxVector

class Vector private constructor(private val gdxVector: GdxVector){

	constructor(len: Float, angle: Angle) : this(GdxVector(len, 0f).rotate(angle.toVector().angle()))
	constructor(x: Float, y: Float) : this(GdxVector(x,y))

	fun angle() = Angle(gdxVector.angle())

	@Deprecated("return primitive")
	fun length() = gdxVector.len()

	@Deprecated("returns primitive")
	fun xValue() = gdxVector.x

	@Deprecated("returns primitive")
	fun yValue() = gdxVector.y

	fun invertHorizontal() {
		gdxVector.y = -gdxVector.y
	}

}