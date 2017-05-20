package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class PaddleBallCollision : LogicSystem() {

	override fun update(delta: Timespan) {
		val balls = database.selectBalls()
		val paddles = database.selectPaddles()
		for (paddle in paddles) {
			for (ball in balls) {
				ball.overlaps(paddle) {
					ball.resolveCollision(it)
					ball.bounceOff()
				}
			}
		}
	}

	override fun dispose() {

	}
}