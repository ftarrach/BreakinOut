package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.game.component.circle.Radius
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.Vectorial
import com.fabiantarrach.breakinout.util.Velocity

//class Position(private val x: X,
//               private val y: Y) {
//
//	constructor(x: Float, y: Float): this(
//			X(x),
//			Y(y))
//
//	fun createGdxCircle(radius: Radius): GdxCircle {
//		val circle = GdxCircle()
//		radius.update(circle)
//		x.update(circle)
//		y.update(circle)
//		return circle
//	}
//
//}

class Position(x: Float, y: Float) : Vectorial(x, y) {

	fun createGdxCircle(radius: Radius): GdxCircle {
		val circle = GdxCircle()
		radius.update(circle)
		circle.x = vector.x
		circle.y = vector.y
		return circle
	}

	fun move(velocity: Velocity): Position {
		return plus(velocity) { x, y ->
			Position(x, y)
		}
	}
}
