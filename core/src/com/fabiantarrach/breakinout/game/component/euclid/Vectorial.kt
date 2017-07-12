package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.util.GdxVector

abstract class Vectorial(protected open var x: Float,
                         protected open var y: Float) {

	protected fun applyFriction(other: Vectorial) {
		val vector = GdxVector(x, y)
		val otherVector = GdxVector(other.x, other.y)
		val len = vector.len()
		vector.add(otherVector)
		vector.setLength(len)
		x = vector.x
		y = vector.y
	}

}