package com.fabiantarrach.breakinout.util.screen

import com.badlogic.gdx.ScreenAdapter

open class FitScreen : ScreenAdapter() {

	protected val camera = Camera()

	override fun resize(width: Int, height: Int) {
		camera.update(width, height)
	}

}
