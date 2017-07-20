package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.math.X

abstract class Shape {

	abstract fun ifOverlaps(other: Shape, then: () -> Unit)
	abstract fun render(renderer: GdxShapeRenderer, color: GdxColor)

	abstract fun ifNextTo(other: Shape, then: () -> Unit, ifNot: () -> Unit)
	abstract fun ifUnder(other: Shape, then: () -> Unit, ifNot: () -> Unit)
	abstract fun relativeTo(shape: Shape): X

}