package com.fabiantarrach.breakinout.game.entity_v2.system.rendering

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.fabiantarrach.breakinout.game.entity_v2.Entity

class LineRenderer : Renderer {

	private val renderer = ShapeRenderer()
	private val toolbox = RenderingToolbox(renderer)

	// TODO: wrap up List<Entity>
	override fun render(entities: List<Entity>) {
		renderer.begin(ShapeRenderer.ShapeType.Line)
		for (e in entities) {
			e.render(toolbox)
		}
		renderer.end()
	}
}
