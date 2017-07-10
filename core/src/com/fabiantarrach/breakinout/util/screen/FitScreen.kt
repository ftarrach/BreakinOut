package com.fabiantarrach.breakinout.util.screen

import com.badlogic.gdx.Screen

abstract class FitScreen : Screen {

	protected val camera = Camera()

	override fun resize(width: Int, height: Int) {
		camera.update(width, height)
	}

}
