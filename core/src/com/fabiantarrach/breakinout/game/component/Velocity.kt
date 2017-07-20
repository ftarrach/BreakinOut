package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.math.Factor
import com.fabiantarrach.breakinout.util.math.Vectorial
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y
import java.util.*

class Velocity(x: X, y: Y) : Vectorial(x, y) {

	constructor(x: Float, y: Float) : this(X(x), Y(y))

	fun move(x: X) = this.x + x
	fun move(y: Y) = this.y + y

	operator fun plus(other: Velocity) = super.plus(other, ::Velocity)
	operator fun minus(other: Velocity) = super.minus(other, ::Velocity)
	operator fun times(time: Timespan) = super.scale(time, ::Velocity)

	fun cease(friction: Friction) = super.scale(friction, ::Velocity)

	fun deflectFront() = Velocity(x, -y)
	fun deflectSide() = Velocity(-x, y)

	fun ifMovingDown(then: () -> Unit) = y.ifNegative(then)
	fun ifMovingRight(then: () -> Unit) = x.ifNegative(then)

	fun randomizeAngle(): Velocity {
		val randomAngle = Random().nextInt(360).toFloat()
		val angle = Angle(randomAngle)
		return rotate(angle)
	}

	fun push(push: Velocity) = super.push(push, ::Velocity)

	private fun rotate(angle: Angle) =
			super.rotate(angle, ::Velocity)

	fun faster(): Velocity {
		val factor = Factor(5f)
		return super.scale(factor, ::Velocity)
	}

	fun slamX(other: Velocity): Velocity {
		var newX = x
		x.ifNegative {
			newX = x - other.x
		}
		x.ifPositive {
			newX = x + other.x
		}
		println("$x => $newX")
		return Velocity(newX, y)
	}

	fun invert() = Velocity(-x, -y)
}
