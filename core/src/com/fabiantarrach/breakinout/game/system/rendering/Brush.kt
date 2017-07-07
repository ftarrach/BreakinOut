package com.fabiantarrach.breakinout.game.system.rendering

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxShapeRenderer

class Brush(private val renderer: GdxShapeRenderer) {

	fun drawRectangle(rectangle: GdxRectangle, color: Color) {
		renderer.color = color
		rectangle.draw()
	}

	fun drawCircle(circle: GdxCircle, color: Color) {
		renderer.color = color
		circle.draw()
	}

	private fun GdxRectangle.draw() {
		renderer.rect(x, y, width, height)
	}

	private fun GdxCircle.draw() {
		renderer.circle(x, y, radius, 20)
	}

}