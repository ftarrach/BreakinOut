package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.badlogic.gdx.math.Rectangle as GdxRectangle

class Position(private var x: Float, private var y: Float) {
	@Deprecated("Getter")
	fun xCoordinate() = x

	@Deprecated("Getter")
	fun yCoordinate() = y

	fun moveVelocity(target: Position): Velocity {
		return Velocity(target.x - x, 0f)
	}
}
