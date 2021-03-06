package com.fabiantarrach.breakinout.util.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.viewport.FitViewport
import com.fabiantarrach.breakinout.game.component.MousePosition
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

	fun mousePosition(): MousePosition {
		val x = Gdx.input.x.toFloat()
		val y = Gdx.input.y.toFloat()
		val gdxVector = GdxVector3(x, y, 0f)
		camera.unproject(gdxVector)
		return MousePosition(gdxVector.x, gdxVector.y)
	}

//	fun mousePosition(screenPosition: GdxVector3, block: (MousePosition) -> Unit) {
//		val gamePosition = camera.unproject(screenPosition)
//		val position = MousePosition(gamePosition.x, gamePosition.y)
//		block(position)
//	}

}