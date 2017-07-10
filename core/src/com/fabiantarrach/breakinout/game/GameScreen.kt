package com.fabiantarrach.breakinout.game

import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.screen.FitScreen

class GameScreen : FitScreen() {

	private val engine = BreakinOutEngine(camera)

	override fun show() {
		engine.buildGame()
	}

	override fun render(delta: Float) {
		engine.update(
				Timespan(delta))
	}

	override fun dispose() {
		engine.dispose()
	}

	override fun hide() {}

	override fun pause() {} // TODO: pause game if focus lost?

	override fun resume() {} // TODO: ... and resume it
}