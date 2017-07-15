package com.fabiantarrach.breakinout.game.component

import com.badlogic.gdx.Gdx

class MousePosition(x: VectorialElement, y: VectorialElement) : Vectorial(x, y) {

	constructor(x: Float, y: Float): this(VectorialElement(x), VectorialElement(y))

	constructor() : this(Gdx.input.x.toFloat(), Gdx.input.y.toFloat())

	fun moveVelocity(): Velocity {
		return keepX { x ->
			Velocity(x, VectorialElement(0f))
		}
	}



}