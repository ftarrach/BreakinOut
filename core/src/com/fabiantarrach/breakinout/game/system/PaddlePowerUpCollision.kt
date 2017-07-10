package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.game.entity.powerup.PowerUp
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class PaddlePowerUpCollision : LogicSystem() {

	override fun update(delta: Timespan) =
			database.each(Paddle::class.java) {
				checkPaddle(it)
			}

	private fun checkPaddle(paddle: Paddle) =
			database.eachPowerUp {
				checkCollision(paddle, it)
			}

	private fun checkCollision(paddle: Paddle, powerup: PowerUp) {
		paddle.ifOverlaps(powerup) {
			powerup.activate(database)
			powerup.hit()
		}
	}

}