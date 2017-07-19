package com.fabiantarrach.breakinout.game.entity.powerup

import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import java.util.*

class PowerUpFactory {

	fun createRandom(rectangle: Rectangle): PowerUp {
		val random = Random()
		when (random.nextInt(3)) {
			0 -> return BiggerPaddle(rectangle)
			1 -> return SmallerPaddle(rectangle)
			2 -> return ExtraBall(rectangle)
		}
		throw RuntimeException("error during power up generation")
	}

}