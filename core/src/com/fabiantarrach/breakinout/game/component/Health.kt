package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.ifTrue
import com.fabiantarrach.breakinout.util.lighter

class Health(private var points: Int) {

	init {
		if (points < 0)
			throw IllegalArgumentException("negative points are not allowed")
	}

	fun ifDead(then: () -> Unit) =
			(points <= 0)
					.ifTrue(then)

	fun ifAlive(then: () -> Unit) =
			(points > 0).
					ifTrue(then)

	fun hit(died: () -> Unit = {}) =
			(--points == 0)
					.ifTrue(died)

	fun drain() {
		points = 0
	}

	fun createColor(base: GdxColor) =
			(1..points)
					.fold(base) { color, _ ->
						color.lighter()
					}

}