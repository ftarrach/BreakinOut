package com.fabiantarrach.breakinout.game.meta.nextTo

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.chain.Chain
import com.fabiantarrach.breakinout.game.meta.chain.ErrorLink

class NextTo : Chain<Shape>() {

	override val elements =
			listOf(
					CircleRectangle(),
					ErrorLink(NextTo::class))

}