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
		val newX = X(rotatedVector.x) // TODO: don't allow an angle smaller than a certain value, or the angle will be too small to move the entity up/down resulting in a bored player
		val newY = Y(rotatedVector.y)
		return block(newX, newY)
	}

	fun <T : Vectorial> push(other: Vectorial, block: (X, Y) -> T): T {
		val vector = createGdxVector()
		val length = vector.len()
		val added = plus(other, block)
		val addedVector = added.createGdxVector()
		addedVector.setLength(length)
		val newX = X(addedVector.x)
		val newY = Y(addedVector.y)
		return block(newX, newY)
	}

	private fun createGdxVector(): GdxVector {
		val vector = GdxVector()
		x.update(vector)
		y.update(vector)
		return vector
	}

	override fun equals(other: Any?): Boolean {
		if (other != null && other is Vectorial && other.javaClass == this.javaClass)
			return x == other.x && y == other.y
		return false
	}

	override fun hashCode(): Int = 31 * x.hashCode() + y.hashCode()

}