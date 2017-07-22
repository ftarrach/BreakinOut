package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.game.entity.powerup.PowerUp
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class PaddlePowerUpCollision : LogicSystem() {

	override fun update(delta: Timespan) =
			database.cross(Paddle::class, PowerUp::class, this::checkCollision)

	private fun checkCollision(paddle: Paddle, powerup: PowerUp) {
		paddle.ifOverlaps(powerup) {
			powerup.activate(database)
			powerup.die()
		}
	}

}