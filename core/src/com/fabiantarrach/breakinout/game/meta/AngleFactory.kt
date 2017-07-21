package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.game.component.Angle
import java.util.*

class AngleFactory {
	fun createRandomAngle(): Angle {
		val randomNumberGenerator = Random()
		val randomAngle = randomNumberGenerator.nextInt(360)
		val randomFloatAngle = randomAngle.toFloat()
		return Angle(randomFloatAngle)
	}
}
