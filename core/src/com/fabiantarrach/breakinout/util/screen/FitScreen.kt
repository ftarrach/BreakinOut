package com.fabiantarrach.breakinout.util.screen

import com.fabiantarrach.breakinout.util.GdxScreen

abstract class FitScreen(worldSize: Float) : GdxScreen {

	protected val camera = Camera(worldSize)

	override fun resize(width: Int, height: Int) {
		camera.update(width, height)
	}

}
