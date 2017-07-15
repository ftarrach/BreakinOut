package com.fabiantarrach.breakinout.game.component

abstract class Shape {

	abstract fun ifOverlaps(other: Shape, then: () -> Unit)
	abstract fun ifUnder(other: Shape, then: () -> Unit, ifNot: () -> Unit)

}