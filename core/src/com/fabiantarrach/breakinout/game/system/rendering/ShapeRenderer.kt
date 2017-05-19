package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.util.engine.SelectedEntities
import com.badlogic.gdx.graphics.glutils.ShapeRenderer as GdxShapeRenderer

abstract class ShapeRenderer : Renderer {

	private val renderer = GdxShapeRenderer()
	private val toolbox = Brush(renderer)

	protected abstract fun type(): GdxShapeRenderer.ShapeType
	protected open fun prepareRenderStep(renderer: GdxShapeRenderer) {}

	override final fun render(entities: SelectedEntities) {
		prepareRenderStep(renderer)
		renderer.begin(type())
		for (e in entities) {
			e.render(toolbox)
		}
		renderer.end()
	}

	override fun dispose() {
		renderer.dispose()
	}

}