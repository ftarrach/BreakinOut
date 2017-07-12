package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxVector
import com.fabiantarrach.breakinout.util.engine.Timespan
import java.util.*

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
//		// currently it is randomize. It should use the relative position to the paddle/brick and it's speed
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

	fun push(other: Friction) {
		applyFriction(other)
	}

	fun randomize() {
		val vector = GdxVector(x, y)
		val angle = Random()
				.nextFloat() * 360f
		vector.rotate(angle)
		this.x = vector.x
		this.y = vector.y
	}

	fun createFriction() = Friction(x * 0.5f, y * 0.5f)
}