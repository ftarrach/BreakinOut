package com.fabiantarrach.breakinout.game_neu.component

import com.fabiantarrach.breakinout.game_neu.component.circle.Radius
import com.fabiantarrach.breakinout.util.GdxCircle

class Position(private val x: X,
               private val y: Y) {

	constructor(x: Float, y: Float): this(
			X(x),
			Y(y))

	fun createGdxCircle(radius: Radius): GdxCircle {
		val circle = GdxCircle()
		radius.update(circle)
		x.update(circle)
		y.update(circle)
		return circle
	}

}