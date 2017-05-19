package com.fabiantarrach.breakinout

import com.fabiantarrach.breakinout.game.GameScreen
import com.fabiantarrach.breakinout.util.KotlinGame

class BreakinOut : KotlinGame() {

	override fun create() {
		screen = GameScreen()
	}

}
