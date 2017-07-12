package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.component.euclid.PositionDifference
import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class BallPaddleCollision : LogicSystem() {

	override fun update(delta: Timespan) =
			database.each(Paddle::class.java) {
				checkPaddle(it)
			}

	private fun checkPaddle(paddle: Paddle) =
			database.each(Ball::class.java) {
				checkCollision(paddle, it)
			}

	private fun checkCollision(paddle: Paddle, ball: Ball) {
		ball.ifMovingDown {
			checkOverlap(paddle, ball)
		}
	}

	private fun checkOverlap(paddle: Paddle, ball: Ball) =
			ball.ifOverlaps(paddle) {
				ball.ifUnder(paddle,
						then = {
							ball.bounceOff(PositionDifference(0f, true))
						},
						ifNot = {
							ball.bounceOff(it)
							paddle.scrub(ball)
						})

			}

}