package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.game.entity.BonusBrick
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.game.entity.powerup.GoodieFactory
import com.fabiantarrach.breakinout.util.math.Chance

class RandomBrickFactory {

	private val goodieFactory = GoodieFactory()

	fun create(x: Float, y: Float, life: Int): Brick {
		var newBrick = Brick(x, y, life)
		Chance(percent = 10).ifSuccess {
			newBrick = BonusBrick(x, y, goodieFactory::createRandom)
		}
		return newBrick
	}

}