package com.fabiantarrach.breakinout.game.meta.overlap

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.Pipe

class Collision : Pipe<Shape>() {

	override val elements =
			listOf(
					CircleRectangle(),
					RectangleRectangle(),
					ThrowError())
}