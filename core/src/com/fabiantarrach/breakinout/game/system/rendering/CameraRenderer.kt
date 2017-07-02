package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.util.engine.ProjectableRenderer
import com.fabiantarrach.breakinout.util.engine.SelectedEntities

class CameraRenderer(private val camera: Camera, private val renderer: ProjectableRenderer) : Renderer {

	override fun render(entities: SelectedEntities<Entity>) {
		renderer.project(camera)
		renderer.render(entities)
	}

	override fun dispose() {
	}

}