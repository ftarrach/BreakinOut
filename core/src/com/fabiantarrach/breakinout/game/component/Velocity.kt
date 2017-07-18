package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.math.Factor
import com.fabiantarrach.breakinout.util.math.Vectorial
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y
import java.util.*

class Velocity(x: X, y: Y) : Vectorial(x, y) {

	constructor(x: Float, y: Float) : this(X(x), Y(y))

	fun move(x: X) = this.x + x
	fun move(y: Y) = this.y + y

	operator fun plus(other: Velocity) =
			super.plus(other) { x, y ->
				Velocity(x, y)
			}

	operator fun minus(other: Velocity) =
			super.minus(other) { x, y ->
				Velocity(x, y)
			}

	operator fun times(time: Factor) =
			super.scale(time) { x, y ->
				Velocity(x, y)
			}

	fun deflectFront() = Velocity(x, -y)
	fun deflectSide() = Velocity(-x, y)

	fun ifMovingDown(then: () -> Unit) = y.ifNegative(then)

	fun randomizeAngle(): Velocity = rotate(Angle(Random().nextFloat() * 360f))

	private fun rotate(angle: Angle): Velocity {
		return Velocity(
				x.rotate(angle, y),
				y.rotate(angle, x))
	}

}
