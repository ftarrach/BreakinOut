package com.fabiantarrach.breakinout.game.entity_v2.system.rendering

import com.badlogic.gdx.math.Rectangle as GdxRectangle

class RenderingToolbox(private val renderer: com.badlogic.gdx.graphics.glutils.ShapeRenderer) {

	fun paintWith(color: com.badlogic.gdx.graphics.Color) {
		renderer.color = color
	}

	fun drawRectangle(x: Float, y: Float, width: Float, height: Float) {
		renderer.rect(x, y, width, height)
	}

	fun drawCircle(x: Float, y: Float, radius: Float) {
		renderer.circle(x, y, radius)
	}

}