package com.fabiantarrach.breakinout.game_neu.component

import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.darker

class Lifepoints(private var lifepoints: Int) {

	init {
		if (lifepoints < 0)
			throw IllegalArgumentException("negative lifepoints are not allowed")
	}

	fun ifDead(then: () -> Unit) {
		if (lifepoints <= 0)
			then()
	}

	fun ifAlive(then: () -> Unit) {
		if (lifepoints > 0)
			then()
	}

	fun hit(died: () -> Unit = {}) {
		lifepoints--
		if (lifepoints == 0)
			died()
	}

	fun drainAll() {
		lifepoints = 0
	}

	fun createColor(base: GdxColor) = (0..lifepoints)
			.fold(base) { color, _ ->
				color.darker()
			}

}