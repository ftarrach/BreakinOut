package com.fabiantarrach.breakinout.util.math

import com.fabiantarrach.breakinout.util.ifTrue
import java.util.*

class Chance(private val percent: Int) {

	private val number = Random()
			.nextInt(99)

	fun ifSuccess(action: () -> Unit) =
			(number < percent)
					.ifTrue(action)

}
