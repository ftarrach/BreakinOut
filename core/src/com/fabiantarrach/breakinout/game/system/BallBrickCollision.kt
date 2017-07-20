package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.game.meta.Collision
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class BallBrickCollision : LogicSystem() {

	// TODO: collision as a variable in checkBrick passed around and updated
	private val collision = Collision()

	override fun update(delta: Timespan) =
			database.each(Ball::class.java) {
				checkBrick(it)
			}

	private fun checkBrick(ball: Ball) {
		collision.reset()
		database.each(Brick::class.java) {
			checkOverlap(ball, it)
		}
		collision.ifOccured {
			bounce(ball)
		}
	}

	private fun bounce(ball: Ball) {
		ball.revertLastMove()
		collision.ifSideCollision(
				then = ball::bounceOffSide,
				orElse = ball::bounceOffFront
		)
	}

	private fun checkOverlap(ball: Ball, brick: Brick) =
			ball.ifOverlaps(brick) {
				collision.occured()
				ball.ifNextTo(brick, then = collision::markSide)
				hitBrick(brick)
			}

	private fun hitBrick(brick: Brick) =
			brick.hit(died = {
				createPowerUp(brick)
			})

	private fun createPowerUp(brick: Brick) {
		if (Math.random() < 0.2f)
			brick.createPowerUp(database)
	}
}