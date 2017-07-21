package com.fabiantarrach.breakinout.game.component

import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.math.X

abstract class Shape {

	abstract fun move(velocity: Velocity)

	abstract fun render(renderer: GdxShapeRenderer, color: GdxColor)

	abstract fun relativeTo(shape: Shape): X
	abstract fun relativeTo(x: X): X

}