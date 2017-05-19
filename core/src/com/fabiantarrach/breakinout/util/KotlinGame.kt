package com.fabiantarrach.breakinout.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.ScreenAdapter
import ktx.app.KotlinApplication

/**
 * A [KotlinApplication] that delegates to a [Screen]. This allows an application to easily have multiple screens.
 *
 * Screens are not disposed automatically. You must handle whether you want to keep screens around or dispose of them when another
 * startScreen is set.
 */
abstract class KotlinGame(fixedTimeStep: Float = 1f / 60f, maxDeltaTime: Float = 1f) : KotlinApplication(fixedTimeStep, maxDeltaTime) {

	/**
	 * empty screen for first initialization to avoid nullability for [screen]
	 */
	class EmptyScreen : ScreenAdapter()

	protected var screen: Screen = EmptyScreen()
		set(value) {
			field.hide()
			field = value
			field.show()
			field.resize(Gdx.graphics.width, Gdx.graphics.height)
		}

	override fun dispose() = screen.hide()

	override fun pause() = screen.pause()

	override fun resume() = screen.resume()

	override fun render(delta: Float) = screen.render(delta)

	override fun resize(width: Int, height: Int) = screen.resize(width, height)

}
