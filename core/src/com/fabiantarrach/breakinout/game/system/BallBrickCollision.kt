package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class BallBrickCollision : LogicSystem() {

	override fun update(delta: Timespan) {
		database.eachBall {
			checkBrick(it)
		}
	}

	private fun checkBrick(ball: Ball) {
		database.eachBrick {
			checkCollision(ball, it)
		}
	}

	private fun checkCollision(ball: Ball, brick: Brick) {
		ball.overlaps(brick) {
			brick.die()
			ball.bounceOff()
		}
	}

}