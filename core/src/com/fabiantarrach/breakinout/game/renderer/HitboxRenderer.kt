package com.fabiantarrach.breakinout.game.renderer

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Circle as GdxCircle
import com.badlogic.gdx.math.Rectangle as GdxRectangle

class HitboxRenderer : Renderer {

	private val batch = ShapeRenderer()

	fun begin() = batch.begin(ShapeRenderer.ShapeType.Line)
	fun end() = batch.end()

	override fun drawCircle(circle: com.badlogic.gdx.math.Circle, color: Color) {
		batch.color = color
		batch.circle(circle.x, circle.y, circle.radius)
	}

	override fun drawBox(rectangle: com.badlogic.gdx.math.Rectangle, color: Color) {
		batch.color = color
		batch.box(rectangle.x, rectangle.y, 0f, rectangle.width, rectangle.height, 0f)
	}

	override fun drawLine(x: Float, y: Float, x2: Float, y2: Float) {
		batch.line(x, y, x2, y2)
	}

	override fun useCamera(camera: OrthographicCamera) {
		batch.projectionMatrix = camera.combined
	}

	override fun dispose() {
		batch.dispose()
	}

}