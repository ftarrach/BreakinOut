package com.fabiantarrach.breakinout.util

import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.viewport.FitViewport

open class FitScreen : ScreenAdapter() {

	protected val camera = OrthographicCamera()
	private val viewport = FitViewport(800f, 600f, camera)

	init {
		viewport.apply()
	}

	override fun resize(width: Int, height: Int) {
		viewport.update(width, height)
	}

}
