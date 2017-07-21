package com.fabiantarrach.breakinout.util.math

import com.fabiantarrach.breakinout.util.ifTrue
import java.util.*

class Chance(private val successChance: Float) {

	private val number = Random()
						.nextFloat()

	fun ifSuccess(action: () -> Unit) =
			(number <= successChance)
					.ifTrue(action)

}