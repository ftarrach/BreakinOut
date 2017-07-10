package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.game.util.Angle
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.engine.Timespan

class Velocity(x: Float, y: Float) : Vectorial(x, y) {

	operator fun times(delta: Timespan): Velocity =
			delta.normalize(x, y) { x, y ->
				Velocity(x, y)
			}

	fun invertHorizontal() {
		x = -x
	}

	fun invertVertical() {
		y = -y
	}

	// TODO: reuse this
//	private fun movingDown() {
//		val velocityVector = GdxVector(x, y)
//		val minAngle = Angle(45f)
//		val maxAngle = Angle(135f)
//		// TODO: currently it is random. It should use the relative position to the paddle/brick and it's speed
//		RandomVector(minAngle, maxAngle)
//				.randomize(velocityVector)
//		x = velocityVector.x
//		y = velocityVector.y
//	}

	fun ifMovingDown(movingDown: () -> Unit, movingUp: () -> Unit = {}) {
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

	fun spin(difference: PositionDifference) {
		val min = Angle(-45f)
		val max = Angle(45f)
		// TODO: think about it how i can do it: Depending on hit position use other angle
		}

	operator fun plus(other: Velocity) =
			Velocity(x + other.x, y + other.y)

	operator fun times(other: Float) =
			Velocity(x * other, y * other)
}