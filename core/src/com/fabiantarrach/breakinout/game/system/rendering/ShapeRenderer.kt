package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.GdxShapeType
import com.fabiantarrach.breakinout.util.engine.ProjectableRenderer
import com.fabiantarrach.breakinout.util.screen.Camera

class ShapeRenderer(private val type: GdxShapeType) : ProjectableRenderer {

	private val renderer = GdxShapeRenderer()
	private val toolbox = Brush(renderer)

	override fun project(camera: Camera) {
		camera.projectOn(renderer)
	}

	override fun prepareRendering() {
		renderer.begin(type)
	}

	override fun render(entity: Entity) {
		entity.render(toolbox)
	}

	override fun endRendering() {
		renderer.end()
	}

	override fun dispose() {
		renderer.dispose()
	}

}