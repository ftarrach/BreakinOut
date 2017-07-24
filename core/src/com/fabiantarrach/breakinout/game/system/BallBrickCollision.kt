package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.game.meta.Collision
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.math.Chance

class BallBrickCollision : LogicSystem() {

	override fun update(delta: Timespan) =
			database.each(Ball::class) {
				checkBrick(it)
			}

	private fun checkBrick(ball: Ball) {
		val collision = Collision()
		database.each(Brick::class) {
			checkOverlap(ball, it, collision)
		}
		collision.ifOccured {
			bounce(ball, collision)
		}
	}

	private fun bounce(ball: Ball, collision: Collision) =
			collision.ifSideCollision(
					then = ball::bounceOffSide,
					orElse = ball::bounceOffFront)

	private fun checkOverlap(ball: Ball, brick: Brick, collision: Collision) =
			ball.ifOverlaps(brick) {
				collision.occured()
				ball.ifNextTo(brick, then = collision::markSide)
				hit(brick)
			}

	private fun hit(brick: Brick) =
			brick.hit(died = {
				createPowerUp(brick)
			})

	private fun createPowerUp(brick: Brick) =
			Chance(33).ifSuccess {
				val powerUp = brick.createPowerUp()
				database.add(powerUp)
			}
}