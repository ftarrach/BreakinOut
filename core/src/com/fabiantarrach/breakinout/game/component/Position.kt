package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.game.component.circle.Radius
import com.fabiantarrach.breakinout.util.GdxCircle

class Position(x: VectorialElement, y: VectorialElement) : Vectorial(x, y) {

	constructor(x: Float, y: Float): this(VectorialElement(x), VectorialElement(y))

	fun createGdxCircle(radius: Radius): GdxCircle {
		val circle = createGdxCircle()
		radius.update(circle)
		return circle
	}

	fun move(velocity: Velocity): Position {
		return plus(velocity) { x, y ->
			Position(x, y)
		}
	}

}
