package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.badlogic.gdx.math.Vector2 as GdxVector

class Velocity(x: Float, y: Float) : Vectorial(x, y) {

	operator fun times(delta: Timespan): Velocity =
			delta.normalize(x, y) { newX, newY ->
				Velocity(newX, newY)
			}

	fun invertHorizontal() {
		this.y = -y
	}

	fun move(rectangle: GdxRectangle) {
		rectangle.x += x
		rectangle.y += y
	}

	fun move(circle: GdxCircle) {
		circle.x += x
		circle.y += y
	}

}