package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.game.system.rendering.Renderer
import com.fabiantarrach.breakinout.game.system.rendering.Camera

class CameraRenderer(private val camera: Camera, private val renderer: ProjectableRenderer) : Renderer {

	override fun render(entities: SelectedEntities<Entity>) {
		renderer.project(camera)
		renderer.render(entities)
	}

	override fun dispose() {
	}

}