package com.fabiantarrach.breakinout.screens

import com.fabiantarrach.breakinout.game_neu.BreakinOutEngine
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.screen.FitScreen
import com.fabiantarrach.breakinout.util.screen.ScreenState

class GameScreen(screenState: ScreenState) : FitScreen(1f) {

	private val engine = BreakinOutEngine(screenState, camera)

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

	override fun pause() {} // TODO: pause screenState if focus lost?

	override fun resume() {} // TODO: ... and resume it
}