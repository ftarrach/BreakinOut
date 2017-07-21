package com.fabiantarrach.breakinout.game.meta.under

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.chain.Chain

class Under : Chain<Shape>() {
	override val elements =
			listOf(
					CircleRectangle()
			)

}