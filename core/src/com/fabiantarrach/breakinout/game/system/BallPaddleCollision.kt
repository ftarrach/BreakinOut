package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class BallPaddleCollision : LogicSystem() {

	override fun update(delta: Timespan) =
		database.cross(Paddle::class, Ball::class, this::checkCollision)

	private fun checkCollision(paddle: Paddle, ball: Ball) =
			ball.ifMovingDown {
				checkOverlap(paddle, ball)
			}

	private fun checkOverlap(paddle: Paddle, ball: Ball) =
			ball.ifOverlaps(paddle) {
				resolveOverlap(ball, paddle)
			}

	private fun resolveOverlap(ball: Ball, paddle: Paddle) =
			ball.ifUnderFront(paddle,
					then = {
						ball.bounceOffSide()
						paddle.bat(ball)
					},
					ifFront = {
						ball.bounceOffFront(paddle)
					})

}