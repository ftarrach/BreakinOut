package com.fabiantarrach.breakinout.game.component.euclid

abstract class Vectorial(protected open var x: Float,
                         protected open var y: Float) {

	fun move(other: Vectorial) {
		other.x += x
		other.y += y
	}

}