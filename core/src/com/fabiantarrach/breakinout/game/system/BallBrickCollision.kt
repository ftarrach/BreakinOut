package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.component.euclid.NoPositionDifference
import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class BallBrickCollision : LogicSystem() {

	override fun update(delta: Timespan) =
			database.each(Ball::class.java) {
				checkBrick(it)
			}

	private fun checkBrick(ball: Ball) {
		var overlapped = false
		database.each(Brick::class.java) {
			checkCollision(ball, it) { overlapped = true } // TODO: (hidden) against indentation rule
		}
		if (overlapped)
			ball.bounceOff(NoPositionDifference)
	}

	private fun checkCollision(ball: Ball, brick: Brick, collisionOccurred: () -> Unit) {
		ball.ifOverlaps(brick) {
			brick.hit()
			collisionOccurred()
			val powerUp = brick.createPowerUp()
			database.add(powerUp)
		}
	}
}