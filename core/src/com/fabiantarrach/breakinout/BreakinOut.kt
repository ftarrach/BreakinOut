package com.fabiantarrach.breakinout

import com.fabiantarrach.breakinout.screens.MainMenu
import com.fabiantarrach.breakinout.util.KotlinGame

class BreakinOut : KotlinGame() {

	override fun create() {
		showScreen(
				MainMenu(this))
//		showScreen(
//				GameScreen(this))
	}

}
