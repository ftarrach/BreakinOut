package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.Numerical
import com.fabiantarrach.breakinout.util.engine.Timespan

// TODO: make VectorialElement abstract and let specific Vectorials decide of the subtype
// TODO: ok... REALLY split it...
class VectorialElement(value: Float) : Numerical(value) {

	operator fun plus(other: VectorialElement) =
			VectorialElement(
					super.plus(other))

	operator fun plus(other: X) =
			X(
					super.plus(other))

	operator fun plus(other: Y) =
			Y(
					super.plus(other))

	operator fun minus(other: VectorialElement) =
			VectorialElement(
					super.minus(other))

	operator fun times(timespan: Timespan) =
			VectorialElement(
					super.times(timespan))

	operator fun times(factor: Factor) =
			VectorialElement(
					super.times(factor))

	fun createGdxCircle(y: VectorialElement): GdxCircle {
		val circle = GdxCircle()
		circle.x = value
		circle.y = y.value
		return circle
	}

	fun invert(): VectorialElement {
		return VectorialElement(-this)
	}

}