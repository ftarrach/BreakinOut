package com.fabiantarrach.breakinout.game.meta.overlap

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.meta.chain.Link

class RectangleRectangle : Link<Shape> {
	override fun resolve(one: Shape, another: Shape, then: () -> Unit, orElse: () -> Unit, next: () -> Link<Shape>) {
		if (one is Rectangle && another is Rectangle)
			return one.ifOverlaps(another, then)
		next().resolve(one, another, then, orElse, next)
	}
}