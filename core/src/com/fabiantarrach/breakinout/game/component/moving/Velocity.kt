package com.fabiantarrach.breakinout.game.component.moving

import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.badlogic.gdx.math.Vector2 as GdxVector

class Velocity(private var x: Float, private var y: Float) {

	operator fun times(delta: Timespan): Velocity =
			Velocity(delta * x, delta * y)

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