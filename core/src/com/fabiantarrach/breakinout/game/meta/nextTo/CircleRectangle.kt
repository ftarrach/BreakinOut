package com.fabiantarrach.breakinout.game.meta.nextTo

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.component.circle.Circle
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.meta.chain.Link

class CircleRectangle : Link<Shape> {
	override fun resolve(one: Shape, another: Shape, then: () -> Unit, orElse: () -> Unit, next: () -> Link<Shape>) {
		if (one is Rectangle && another is Circle)
			return another.ifNextTo(one, then, orElse)
		if (one is Circle && another is Rectangle)
			return one.ifNextTo(another, then, orElse)
		next().resolve(one, another, then, orElse, next)
	}
}