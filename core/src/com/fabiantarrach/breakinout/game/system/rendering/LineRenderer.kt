package com.fabiantarrach.breakinout.game.system.rendering

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer as GdxShapeRenderer

// TODO: wrapper class for OrthographicCamera
class LineRenderer(private val camera: OrthographicCamera) : ShapeRenderer() {

	override fun type(): GdxShapeRenderer.ShapeType = GdxShapeRenderer.ShapeType.Line

	override fun prepareRenderStep(renderer: GdxShapeRenderer) {
		super.prepareRenderStep(renderer)
		renderer.projectionMatrix = camera.combined
	}

}
