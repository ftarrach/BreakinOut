package com.fabiantarrach.breakinout

import com.fabiantarrach.breakinout.mainmenu.MainMenu
import com.fabiantarrach.breakinout.util.KotlinGame

class BreakinOut : KotlinGame() {

	override fun create() {
		val startScreen = MainMenu(this)
		showScreen(startScreen)
	}

}
