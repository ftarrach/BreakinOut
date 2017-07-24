package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.ifTrue
import com.fabiantarrach.breakinout.util.lighter

class Lifepoints(private var lifepoints: Int) {

	init {
		if (lifepoints < 0)
			throw IllegalArgumentException("negative lifepoints are not allowed")
	}

	fun ifDead(then: () -> Unit) =
			(lifepoints <= 0)
					.ifTrue(then)

	fun ifAlive(then: () -> Unit) =
			(lifepoints > 0).
					ifTrue(then)

	fun hit(died: () -> Unit = {}) =
			(--lifepoints == 0)
					.ifTrue(died)

	fun drain() {
		lifepoints = 0
	}

	fun createColor(base: GdxColor) =
			(1..lifepoints)
					.fold(base) { color, _ ->
						color.lighter()
					}

}