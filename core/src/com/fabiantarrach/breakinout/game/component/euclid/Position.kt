package com.fabiantarrach.breakinout.game.component.euclid

class Position(x: Float, y: Float) : Vectorial(x, y) {

	fun createMoveVelocity(target: Position): Velocity {
		val velocityX = (target.x - x) * 5f
		val velocityY = 0f
		return Velocity(velocityX, velocityY)
	}
}
