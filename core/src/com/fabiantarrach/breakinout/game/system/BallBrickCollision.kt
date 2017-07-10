package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.component.euclid.NoPositionDifference
import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class BallBrickCollision : LogicSystem() {

	private var overlapped = false

	override fun update(delta: Timespan) =
			database.each(Ball::class.java) {
				checkBrick(it)
			}

	private fun checkBrick(ball: Ball) {
		overlapped = false
		database.each(Brick::class.java) {
			checkCollision(ball, it)
		}
		if (overlapped)
			ball.bounceOff(NoPositionDifference)
	}

	private fun checkCollision(ball: Ball, brick: Brick) =
			ball.ifOverlaps(brick) {
				overlapped = true
				hitBrick(brick)
			}

	private fun hitBrick(brick: Brick) =
			brick.hit {
				createPowerUp(brick)
			}

	private fun createPowerUp(brick: Brick) {
		if (Math.random() < 0.2f)
			database.add(
					brick.createPowerUp())
	}
}