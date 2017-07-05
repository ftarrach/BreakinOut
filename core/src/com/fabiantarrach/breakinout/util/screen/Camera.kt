package com.fabiantarrach.breakinout.util.screen

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.utils.viewport.FitViewport
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.util.GdxShapeRenderer

class Camera {
	private val camera: OrthographicCamera = OrthographicCamera()
	private val viewport = FitViewport(2f, 2f, camera)

	init {
		camera.position.set(0f, 0f, 0f)
		viewport.apply()
	}

	fun projectOn(renderer: GdxShapeRenderer) {
		renderer.projectionMatrix = camera.combined
	}

	fun update(width: Int, height: Int) {
		viewport.update(width, height)
	}

	fun getMousePosition(x: Float, y: Float): Position {
		val sceenPosition = Vector3(x, y, 0f)
		val position = camera.unproject(sceenPosition)
		return Position(position.x, position.y)
	}

}