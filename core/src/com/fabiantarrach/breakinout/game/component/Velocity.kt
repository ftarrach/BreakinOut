package com.fabiantarrach.breakinout.game.component

import com.badlogic.gdx.math.Vector2
import com.fabiantarrach.breakinout.game.data.Angle
import com.fabiantarrach.breakinout.game.data.Speed
import com.fabiantarrach.breakinout.util.Milliseconds

class Velocity(x: Float = 0f, y: Float = 0f) {
	private val velocityVector = Vector2(x, y)

	fun frameVelocity(delta: Milliseconds) =
			Velocity(delta * velocityVector.x, delta * velocityVector.y)

	fun angle(speed: Speed, angleDeg: Angle) {
		val newVelocity = angleDeg.vectorOf(speed)
		velocityVector.set(newVelocity)
	}

	fun invertX() {
		velocityVector.x = -velocityVector.x
	}

	fun invertY() {
		velocityVector.y = -velocityVector.y
	}

	fun isMoving() = !velocityVector.isZero

	@Deprecated("Getter") fun xValue() = velocityVector.x
	@Deprecated("Getter") fun yValue() = velocityVector.y

	fun addAngle(angle: Angle) {
		velocityVector.rotate(angle.floatValue())
	}

}
