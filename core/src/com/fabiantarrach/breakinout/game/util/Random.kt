package com.fabiantarrach.breakinout.game.util

import com.fabiantarrach.breakinout.util.GdxVector

class RandomVector(private val minAngle: Angle,
                   private val maxAngle: Angle) {

	fun randomize(vector: GdxVector) {
		minAngle.createRandom(maxAngle)
				.rotate(vector)
	}
}

class Angle(private val degree: Float) {

	fun createRandom(maxAngle: Angle): Angle {
		val min = degree
		val max = maxAngle.degree
		val newDegrees = Math.random().toFloat() * (max - min) + min
		return Angle(newDegrees)
	}

	fun rotate(vector: GdxVector) {
		vector.setAngle(degree)
	}

}
