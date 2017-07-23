package com.fabiantarrach.breakinout.mainmenu

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.graphics.GL20
import com.fabiantarrach.breakinout.game.GameScreen
import com.fabiantarrach.breakinout.util.GdxSpriteBatch
import com.fabiantarrach.breakinout.util.screen.FitScreen
import com.fabiantarrach.breakinout.util.screen.ScreenState

class MainMenu(screenState: ScreenState) : FitScreen(256f) {

	private val sb = GdxSpriteBatch()
	private val text = CenteredText("press left mouse button to start a new game")

	init {
		Gdx.input.inputProcessor = object : InputAdapter() {
			override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
				screenState.showScreen(GameScreen(screenState))
				return true
			}
		}
	}

	override fun render(delta: Float) {
		camera.projectOn(sb)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
		sb.begin()
		text.draw(sb)
		sb.end()
	}

	override fun hide() {}

	override fun show() {}

	override fun pause() {}

	override fun resume() {}

	override fun dispose() {}
}