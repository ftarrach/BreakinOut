package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.math.Y

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
						bounceOff(ball, paddle)
					})

	private fun bounceOff(ball: Ball, paddle: Paddle) {
		ball.bounceOffFront()
		paddle.scrub(ball)
		paddle.push(ball)


	}
}