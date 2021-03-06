package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.goodie.BiggerPaddle
import com.fabiantarrach.breakinout.game.entity.goodie.ExtraBall
import com.fabiantarrach.breakinout.game.entity.goodie.Goodie
import com.fabiantarrach.breakinout.game.entity.goodie.SmallerPaddle
import java.util.*

class GoodieFactory {

	fun createRandom(rectangle: Rectangle): Goodie {
		val random = Random()
		when (random.nextInt(3)) {
			0 -> return BiggerPaddle(rectangle)
			1 -> return SmallerPaddle(rectangle)
			2 -> return ExtraBall(rectangle)
		}
		throw RuntimeException("error during power up generation")
	}

}