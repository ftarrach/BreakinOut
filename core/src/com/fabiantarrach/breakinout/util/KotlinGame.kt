package com.fabiantarrach.breakinout.util

import com.badlogic.gdx.Gdx
import com.fabiantarrach.breakinout.util.screen.ScreenState
import ktx.app.KotlinApplication

abstract class KotlinGame : KotlinApplication(), ScreenState {

	class EmptyScreen : GdxScreenAdapter()

	private var screen: GdxScreen = EmptyScreen()

	override fun showScreen(screen: GdxScreen) {
		this.screen.hide()
		this.screen = screen
		this.screen.show()
		this.screen.resize(Gdx.graphics.width, Gdx.graphics.height)
	}

	override fun dispose() = screen.hide()

	override fun pause() = screen.pause()

	override fun resume() = screen.resume()

	override fun render(delta: Float) = screen.render(delta)

	override fun resize(width: Int, height: Int) = screen.resize(width, height)

}
