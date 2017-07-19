package com.fabiantarrach.breakinout.util.math

import com.fabiantarrach.breakinout.game.component.Angle
import com.fabiantarrach.breakinout.util.GdxVector

abstract class Vectorial(protected val x: X,
                         protected val y: Y) {

	protected fun <T> plus(other: Vectorial, block: (X, Y) -> T): T {
		val newX = x + other.x
		val newY = y + other.y
		return block(newX, newY)
	}

	protected fun <T> minus(other: Vectorial, block: (X, Y) -> T): T {
		val newX = x - other.x
		val newY = y - other.y
		return block(newX, newY)
	}

	protected fun <T> scale(factor: Factor, block: (X, Y) -> T): T {
		val newX = x * factor
		val newY = y * factor
		return block(newX, newY)
	}

	protected fun <T : Vectorial> rotate(angle: Angle, block: (X, Y) -> T): T {
		val vector = createGdxVector()
		val rotatedVector = angle.rotate(vector)
		val newX = X(rotatedVector.x)
		val newY = Y(rotatedVector.y)
		return block(newX, newY)
	}

	fun <T : Vectorial> push(other: Vectorial, block: (X, Y) -> T): T {
		val vector = createGdxVector()
		val length = vector.len()
		val added = plus(other, block)
		val addedVector = added.createGdxVector()
		addedVector.setLength(length)
		return block(X(addedVector.x), Y(addedVector.y))
	}

	private fun createGdxVector(): GdxVector {
		val vector = GdxVector()
		x.update(vector)
		y.update(vector)
		return vector
	}

	override fun toString(): String {
		return "$x $y"
	}

}