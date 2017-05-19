package com.fabiantarrach.breakinout.game

import com.fabiantarrach.breakinout.util.FitScreen
import com.fabiantarrach.breakinout.util.Milliseconds

class GameScreen : FitScreen() {

	private val engine = BreakinOutEngine(camera)

	override fun show() {
		engine.run()
	}

	override fun render(delta: Float) {
		engine.update(Milliseconds(delta))
	}

	override fun dispose() {
		engine.dispose()
	}
}