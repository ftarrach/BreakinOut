package com.fabiantarrach.breakinout.game.system.rendering

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.fabiantarrach.breakinout.game.entity.Entity

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
