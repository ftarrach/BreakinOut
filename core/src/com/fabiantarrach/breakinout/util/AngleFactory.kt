package com.fabiantarrach.breakinout.util

import com.fabiantarrach.breakinout.game.component.Angle
import java.util.*

class AngleFactory {
	fun createRandomAngle(): Angle {
		val randomNumberGenerator = Random()
		val randomAngle = randomNumberGenerator.nextInt(360)
		val randomFloatAngle = randomAngle.toFloat()
		val angle = Angle(randomFloatAngle)
		return angle
	}
}
