package com.fabiantarrach.breakinout.game.system.rendering

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer as GdxShapeRenderer
import com.badlogic.gdx.math.Rectangle as GdxRectangle

class Brush(private val renderer: GdxShapeRenderer) {

	fun paintWith(color: Color) {
		renderer.color = color
	}

	fun drawRectangle(x: Float, y: Float, width: Float, height: Float) {
		renderer.rect(x, y, width, height)
	}

	fun drawCircle(x: Float, y: Float, radius: Float) {
		renderer.circle(x, y, radius)
	}

}