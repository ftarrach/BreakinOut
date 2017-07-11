package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxShapeRenderer

class Brush(private val renderer: GdxShapeRenderer) {

	fun drawRectangle(rectangle: GdxRectangle, color: GdxColor) {
		renderer.color = color
		rectangle.draw()
	}

	fun drawCircle(circle: GdxCircle, color: GdxColor) {
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