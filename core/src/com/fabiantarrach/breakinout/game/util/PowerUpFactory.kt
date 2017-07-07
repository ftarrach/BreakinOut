package com.fabiantarrach.breakinout.game.util

import com.fabiantarrach.breakinout.game.entity.powerup.BiggerPaddle
import com.fabiantarrach.breakinout.game.entity.powerup.PowerUp
import com.fabiantarrach.breakinout.game.entity.powerup.SmallerPaddle
import java.util.*

class PowerUpFactory(private val x: Float,
                     private val y: Float) {

	fun createRandom(): PowerUp {
		val random = Random()
		when (random.nextInt(2)) {
			0 -> return BiggerPaddle(x, y)
			1 -> return SmallerPaddle(x, y)
		}
		throw RuntimeException("error during power up generation")
	}

}