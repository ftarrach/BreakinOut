package com.fabiantarrach.breakinout.game.systems

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.Milliseconds

typealias PaddlesAndBalls = Pair<Iterable<Paddle>, Iterable<Ball>>

class BallPaddleCollision(val paddlesAndBalls: Unit.() -> PaddlesAndBalls) : LogicSystem {

	override fun update(delta: Milliseconds) {
		val (paddles, balls) = paddlesAndBalls.invoke(Unit)
		paddles.forEach { paddle ->
			balls.forEach { ball ->
				if (ball.overlaps(paddle)) {
					ball.bounceOff(paddle)
					ball.resolveCollision(paddle)
				}
			}
		}
	}
}
