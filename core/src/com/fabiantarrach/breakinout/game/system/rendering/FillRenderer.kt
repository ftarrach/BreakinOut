package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.util.engine.SelectedEntities
import com.badlogic.gdx.graphics.glutils.ShapeRenderer as GdxShapeRenderer

class FillRenderer(camera: Camera = Camera()) : Renderer {

	private val renderer = CameraRenderer(camera, ShapeRenderer(GdxShapeRenderer.ShapeType.Filled))

	override fun render(entities: SelectedEntities<Entity>) {
		renderer.render(entities)
	}

	override fun dispose() {
		renderer.dispose()
	}

}
