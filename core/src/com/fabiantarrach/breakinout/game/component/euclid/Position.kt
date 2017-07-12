package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.game.component.gdx.Vectorial

class Position(x: Float, y: Float) : Vectorial(x, y) {

	fun createMoveVelocity(target: Position): Velocity =
			createDifferenceVector(target) { x, _ ->
				Velocity(x * 5f, 0f)
			}
}