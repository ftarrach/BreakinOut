package com.fabiantarrach.breakinout.game.meta.under

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.component.circle.Circle
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.meta.chain.Handler

class CircleRectangle : Handler<Shape> {
	override fun resolve(one: Shape, another: Shape, then: () -> Unit, orElse: () -> Unit, next: () -> Handler<Shape>) {
		if (one is Rectangle && another is Circle)
			return another.ifUnder(one, then, orElse)
		if (one is Circle && another is Rectangle)
			return one.ifUnder(another, then, orElse)
		next().resolve(one, another, then, orElse, next)
	}

}