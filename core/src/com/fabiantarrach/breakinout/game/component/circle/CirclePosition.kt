package com.fabiantarrach.breakinout.game.component.circle

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.math.Vectorial
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y

class Position(x: X, y: Y) : Vectorial(x, y) {

	constructor(x: Float, y: Float) : this(X(x),
			Y(y))

	fun createGdxCircle(radius: Radius): GdxCircle {
		val circle = GdxCircle()
		x.update(circle)
		y.update(circle)
		radius.update(circle)
		return circle
	}

	fun move(velocity: Velocity): Position {
		val newX = velocity.move(x)
		val newY = velocity.move(y)
		return Position(newX, newY)
	}

}