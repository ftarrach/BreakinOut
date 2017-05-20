package com.fabiantarrach.breakinout.game

import com.fabiantarrach.breakinout.util.FitScreen
import com.fabiantarrach.breakinout.util.engine.Timespan

class GameScreen : FitScreen() {

	private val engine = BreakinOutEngine(camera)

	override fun show() {
		engine.buildGame()
	}

	override fun render(delta: Float) {
		engine.update(Timespan(delta))
	}

	override fun dispose() {
		engine.dispose()
	}
}