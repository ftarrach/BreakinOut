package com.fabiantarrach.breakinout.game.component.euclid

import com.badlogic.gdx.math.Rectangle as GdxRectangle

class Position(private var x: Float, private var y: Float) {
	@Deprecated("Getter")
	fun xCoordinate() = x

	@Deprecated("Getter")
	fun yCoordinate() = y
}
