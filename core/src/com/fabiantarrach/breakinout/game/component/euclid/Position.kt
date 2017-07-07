package com.fabiantarrach.breakinout.game.component.euclid

import com.badlogic.gdx.math.Rectangle as GdxRectangle

class Position(x: Float, y: Float) : Vectorial(x, y) {

	fun moveVelocity(target: Position): Velocity {
		return Velocity(target.x - x, 0f)
	}
}
