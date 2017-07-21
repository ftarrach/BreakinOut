package com.fabiantarrach.breakinout.game.meta.under

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.pipe.Pipe

class Under : Pipe<Shape>() {
	override val elements =
			listOf(
					CircleRectangle()
			)

}