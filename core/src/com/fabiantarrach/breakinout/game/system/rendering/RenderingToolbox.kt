package com.fabiantarrach.breakinout.game.system.rendering

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle as GdxRectangle

class RenderingToolbox(private val renderer: ShapeRenderer) {

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