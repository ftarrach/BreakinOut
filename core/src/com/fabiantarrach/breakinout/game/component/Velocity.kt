package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.AngleFactory
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.math.Vectorial
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y

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
		val angleFactory = AngleFactory()
		val randomAngle = angleFactory.createRandomAngle()
		return rotate(randomAngle, ::Velocity)
	}

	fun push(push: Velocity) = super.push(push, ::Velocity)

	fun invert() = Velocity(-x, -y)
}
