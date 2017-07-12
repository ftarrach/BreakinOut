package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.screens.MainMenu
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.screen.ScreenState

class GameOver(private val screenState: ScreenState) : LogicSystem() {

	override fun update(delta: Timespan) {
		database.ifNoBalls {
			database.clear()
			screenState.showScreen(
					MainMenu(screenState))
		}
	}
}
