package com.fabiantarrach.breakinout.game.meta.overlap

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.chain.Chain
import com.fabiantarrach.breakinout.game.meta.chain.ErrorLink

class Collision : Chain<Shape>() {

	override val links =
			listOf(
					CircleRectangle(),
					RectangleRectangle(),
					ErrorLink(Collision::class))
}