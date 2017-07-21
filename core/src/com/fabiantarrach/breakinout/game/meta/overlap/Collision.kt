package com.fabiantarrach.breakinout.game.meta.overlap

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.chain.Chain

class Collision : Chain<Shape>() {

	override val elements =
			listOf(
					CircleRectangle(),
					RectangleRectangle(),
					ThrowError())
}