package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.game.util.Angle
import com.fabiantarrach.breakinout.game.util.RandomVector
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxVector
import com.fabiantarrach.breakinout.util.engine.Timespan

class Velocity(x: Float, y: Float) : Vectorial(x, y) {

	operator fun times(delta: Timespan): Velocity =
			delta.normalize(x, y) { newX, newY ->
				Velocity(newX, newY)
			}

	fun invertHorizontal() {
		ifMovingDown({
			val velocityVector = GdxVector(x, y)
			val minAngle = Angle(45f)
			val maxAngle = Angle(135f)
			// TODO: currently it is random. It should use the relative position to the paddle/brick and it's speed
			RandomVector(minAngle, maxAngle)
					.randomize(velocityVector)
			x = velocityVector.x
			y = velocityVector.y
		}, {
			y = -y
		})
	}

	fun ifMovingDown(movingDown: () -> Unit, movingUp: () -> Unit) {
		if (y < 0) {
			movingDown()
			return
		}
		movingUp()
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