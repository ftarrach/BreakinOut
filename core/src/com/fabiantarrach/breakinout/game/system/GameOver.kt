package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class GameOver : LogicSystem() {

	override fun update(delta: Timespan) {
		database.ifNoBalls {
			database.clear()
			// TODO: show mainmenu
		}
	}

}