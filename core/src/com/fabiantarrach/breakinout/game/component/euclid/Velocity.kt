package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.game.component.gdx.Vectorial
import com.fabiantarrach.breakinout.game.component.numeric.ScaleFactor
import com.fabiantarrach.breakinout.util.GdxVector
import com.fabiantarrach.breakinout.util.engine.Timespan

class Velocity(x: Float, y: Float) : Vectorial(x, y) {

	private constructor(vector: GdxVector) : this(vector.x, vector.y)

	operator fun times(delta: Timespan): Velocity =
			Velocity(
				scale(delta))

	fun mirrorHorizontal() = invertX()
	fun mirrorVertical() = invertY()

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

	fun ifMovingDown(movingDown: () -> Unit, movingUp: () -> Unit = {}) =
			ifDownwards(movingDown, movingUp)

	fun push(other: Friction) {
		addKeepLength(other)
	}

	fun createFriction(): Friction {
		// TODO: this uses GdxVector
		val friction = scale(
				ScaleFactor(0.5f))
		return Friction(friction.x, friction.y)
	}
}