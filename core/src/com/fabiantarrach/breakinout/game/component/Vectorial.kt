package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.engine.Timespan

// TODO: throw away the Vectorial element, just use number
// TODO: members as abstract members, so the real type can decide what type they are
abstract class Vectorial(protected val x: VectorialElement,
                         protected val y: VectorialElement) {

	constructor(x: Float, y: Float) :
			this(VectorialElement(x),
					VectorialElement(y))

	protected fun <T> plus(other: Vectorial, block: (VectorialElement, VectorialElement) -> T): T {
		val newX = x + other.x
		val newY = y + other.y
		return block(newX, newY)
	}

	protected fun <T> minus(other: Vectorial, block: (VectorialElement, VectorialElement) -> T): T {
		val newX = x - other.x
		val newY = y - other.y
		return block(newX, newY)
	}

	protected fun <T> scale(factor: Timespan, block: (VectorialElement, VectorialElement) -> T): T {
		val newX = x * factor
		val newY = y * factor
		return block(newX, newY)
	}

	protected fun <T> scale(factor: Factor, block: (VectorialElement, VectorialElement) -> T): T {
		val newX = x * factor
		val newY = y * factor
		return block(newX, newY)
	}

	protected fun <T> keepX(block: (VectorialElement) -> T): T = block(x)

	protected fun createGdxCircle() = x.createGdxCircle(y)

}