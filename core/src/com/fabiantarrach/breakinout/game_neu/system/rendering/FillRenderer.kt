package com.fabiantarrach.breakinout.game_neu.system.rendering

import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxShapeType
import com.fabiantarrach.breakinout.util.screen.Camera

class FillRenderer(camera: Camera) : Renderer {

	private val renderer : Renderer

	init {
		val filledShapeRenderer = ShapeRenderer(GdxShapeType.Filled)
		renderer = CameraRenderer(camera, filledShapeRenderer)
	}

	override fun prepareRendering() {
		renderer.prepareRendering()
	}

	override fun endRendering() {
		renderer.endRendering()
	}

	override fun render(entity: Entity) {
		renderer.render(entity)
	}

	override fun dispose() {
		renderer.dispose()
	}

}
