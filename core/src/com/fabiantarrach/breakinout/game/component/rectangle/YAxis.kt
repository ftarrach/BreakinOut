package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.game.component.Y
import com.fabiantarrach.breakinout.util.GdxRectangle

class YAxis(y: Float, height: Float) {
	private val y = Y(y)
	private val height = Height(height)

	fun ifOverlaps(other: YAxis, then: () -> Unit) {
		if (y < other.y + other.height && y + height > other.y)
			then()
	}

	fun update(rectangle: GdxRectangle) {
		y.update(rectangle)
		height.update(rectangle)
	}
}