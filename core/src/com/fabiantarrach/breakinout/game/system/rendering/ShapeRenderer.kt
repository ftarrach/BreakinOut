package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.util.engine.ProjectableRenderer
import com.fabiantarrach.breakinout.util.engine.SelectedEntities
import com.badlogic.gdx.graphics.glutils.ShapeRenderer as GdxShapeRenderer

class ShapeRenderer(private val type: GdxShapeRenderer.ShapeType) : ProjectableRenderer {

	private val renderer = GdxShapeRenderer()
	private val toolbox = Brush(renderer)

	override fun project(camera: Camera) {
		renderer.projectionMatrix = camera.projection()
	}

	override fun render(entities: SelectedEntities<Entity>) {
		renderer.begin(type)
		for (e in entities) {
			e.render(toolbox)
		}
		renderer.end()
	}

	override fun dispose() {
		renderer.dispose()
	}

}