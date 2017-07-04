package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.util.screen.Camera

class CameraRenderer(private val camera: Camera, private val renderer: ProjectableRenderer) : Renderer {

	override fun prepareRendering() {
		renderer.project(camera)
		renderer.prepareRendering()
	}

	override fun endRendering() {
		renderer.endRendering()
	}

	override fun render(entity: Entity) {
		renderer.render(entity)
	}

	override fun dispose() {
	}

}