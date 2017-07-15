package com.fabiantarrach.breakinout.game.entity.powerup

import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import java.util.*

class PowerUpFactory(private val rectangle: Rectangle) {

	fun createRandom(): PowerUp {
		val random = Random()
		when (random.nextInt(1)) {
			0 -> return BiggerPaddle(rectangle)
			1 -> return SmallerPaddle(rectangle)
//			2 -> return ExtraBall(x, y)
		}
// return ExtraBall(x, y)
		throw RuntimeException("error during power up generation")
	}

}