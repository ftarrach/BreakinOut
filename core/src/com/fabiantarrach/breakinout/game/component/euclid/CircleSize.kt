package com.fabiantarrach.breakinout.game.component.euclid

class CircleSize(private val radius: Float) : EuclidianSize {

	@Deprecated("Getter, returns primitive")
	fun radius() = radius

	@Deprecated("Getter, returns primitive")
	fun diameter() = radius * 2

}
