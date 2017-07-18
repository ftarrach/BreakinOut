package com.fabiantarrach.breakinout.util.math

// TODO: throw away the Vectorial element, just use number
// TODO: members as abstract members, so the real type can decide what type they are
abstract class Vectorial(protected val x: X,
                         protected val y: Y) {

	//	constructor(x: Float, y: Float) :
//			this(VectorialElement(x),
//					VectorialElement(y))
//
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

//	protected fun <T> scale(factor: Factor, block: (X, Y) -> T): T {
//		val newX = x * factor
//		val newY = y * factor
//		return block(newX, newY)
//	}
//
//	protected fun <T> keepX(block: (VectorialElement) -> T): T = block(x)
//

	@Deprecated("debug only")
	override fun toString(): String {
		return "$x $y"
	}
}