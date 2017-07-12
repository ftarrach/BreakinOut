package com.fabiantarrach.breakinout.util.screen

import com.badlogic.gdx.utils.viewport.FitViewport
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.util.GdxOrthographicCamera
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.GdxSpriteBatch
import com.fabiantarrach.breakinout.util.GdxVector3

class Camera(worldSize: Float) {
	private val camera = GdxOrthographicCamera()
	private val viewport = FitViewport(worldSize * 2, worldSize * 2, camera)

	init {
		camera.position.set(0f, 0f, 0f)
		viewport.apply()
	}

	fun projectOn(renderer: GdxShapeRenderer) {
		renderer.projectionMatrix = camera.combined
	}

	fun projectOn(renderer: GdxSpriteBatch) {
		renderer.projectionMatrix = camera.combined
	}

	fun update(width: Int, height: Int) {
		viewport.update(width, height)
	}

	fun unprojectMouse(screenPosition: GdxVector3, block: (Position) -> Unit) {
		val gamePosition = camera.unproject(screenPosition)
		val position = Position(gamePosition.x, gamePosition.y)
		block(position)
	}

}