package com.fabiantarrach.breakinout.game.component.euclid

class Position(x: Float, y: Float) : Vectorial(x, y) {

	fun moveVelocity(target: Position): Velocity {
		val velocityX = target.x - x
		val velocityY = 0f
		return Velocity(velocityX, velocityY)
	}
}
