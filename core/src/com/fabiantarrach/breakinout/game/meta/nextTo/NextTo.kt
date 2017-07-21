package com.fabiantarrach.breakinout.game.meta.nextTo

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.pipe.Pipe
import com.fabiantarrach.breakinout.game.meta.overlap.ThrowError

class NextTo : Pipe<Shape>() {

	override val elements =
			listOf(
					CircleRectangle(),
					ThrowError())

}