package com.fabiantarrach.breakinout.game_neu.system.rendering

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.GdxShapeType
import com.fabiantarrach.breakinout.util.screen.Camera

class ShapeRenderer(private val type: GdxShapeType) : ProjectableRenderer {

	private val renderer = GdxShapeRenderer()

	override fun project(camera: Camera) {
		camera.projectOn(renderer)
	}

	override fun prepareRendering() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
		renderer.begin(type)
	}

	override fun render(entity: Entity) {
		entity.render(renderer)
	}

	override fun endRendering() {
		renderer.end()
	}

	override fun dispose() {
		renderer.dispose()
	}

}