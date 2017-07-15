package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.engine.Timespan

class Velocity(x: VectorialElement, y: VectorialElement) : Vectorial(x, y) {

	constructor(x: Float, y: Float) : this(VectorialElement(x), VectorialElement(y))

	fun normalize(time: Timespan) =
			scale(time) { x, y ->
				Velocity(x, y)
			}

	operator fun plus(other: Velocity) =
			super.plus(other) { x, y ->
				Velocity(x, y)
			}

	operator fun minus(other: Velocity) =
			super.minus(other) { x, y ->
				Velocity(x, y)
			}

	fun move(x: X) = this.x + x
	fun move(y: Y) = this.y + y

	operator fun times(factor: Timespan) =
			scale(factor) { x, y ->
				Velocity(x, y)
			}

	operator fun times(factor: Factor) =
			scale(factor) { x, y ->
				Velocity(x, y)
			}

	fun ifMovingDown(then: () -> Unit) {
		y.ifNegative(then)
	}

	fun invertHorizontal() = Velocity(x, y.invert())
	fun invertVertical() = Velocity(x.invert(), y)

	fun randomizeAngle(): Velocity {
		// TODO: create a velocity with the same length as this, but with a randomized angle
		return this
	}

}