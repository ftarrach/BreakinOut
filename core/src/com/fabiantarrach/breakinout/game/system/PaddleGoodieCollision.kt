package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.game.entity.goodie.Goodie
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class PaddleGoodieCollision : LogicSystem() {

	override fun update(delta: Timespan) =
			database.cross(Paddle::class, Goodie::class, this::checkCollision)

	private fun checkCollision(paddle: Paddle, powerup: Goodie) {
		paddle.ifOverlaps(powerup) {
			powerup.activate(database)
			powerup.die()
		}
	}

}