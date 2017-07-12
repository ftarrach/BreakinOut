package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.game.component.numeric.Numerical
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxVector
import java.util.*

abstract class Vectorial(x: Float, y: Float) {

	private val vector = GdxVector(x, y)

	protected fun addKeepLength(other: Vectorial) {
		val vectorLength = vector.len()
		vector.add(other.vector)
		vector.setLength(vectorLength)
	}

	protected fun invertX() { vector.x = -vector.x }

	protected fun invertY() { vector.y = -vector.y }

	protected fun scale(scalar: Numerical) = scalar * vector

	protected fun ifDownwards(downwards: () -> Unit, upwards: () -> Unit) {
		if (vector.y < 0) {
			downwards()
			return
		}
		upwards()
	}

	@Deprecated("using primitives")
	protected fun <T : Vectorial> createDifferenceVector(other: Vectorial, block: (Float, Float) -> T): T {
		val differenceX = other.vector.x - vector.x
		val differenceY = other.vector.y - vector.y
		return block(differenceX, differenceY)
	}

	fun addOn(rectangle: GdxRectangle) {
		rectangle.x += vector.x
		rectangle.y += vector.y
	}

	fun addOn(circle: GdxCircle) {
		circle.x += vector.x
		circle.y += vector.y
	}

	fun randomize() {
		val newAngle = Random()
				.nextFloat() * 360f
		vector.rotate(newAngle)
	}



}