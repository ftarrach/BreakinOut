package com.fabiantarrach.breakinout.game.meta.overlap

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.Resolver

class ThrowError : Resolver<Shape> {
	override fun resolve(one: Shape, another: Shape, then: () -> Unit, orElse: () -> Unit, next: () -> Resolver<Shape>) {
		throw NoCollisionFound(one, another)
	}
}