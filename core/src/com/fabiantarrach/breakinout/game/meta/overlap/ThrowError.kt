package com.fabiantarrach.breakinout.game.meta.overlap

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.pipe.AlgorithmNotFound
import com.fabiantarrach.breakinout.game.meta.pipe.Resolver

class ThrowError : Resolver<Shape> {
	override fun resolve(one: Shape, another: Shape, then: () -> Unit, orElse: () -> Unit, next: () -> Resolver<Shape>) {
		throw AlgorithmNotFound(one, another)
	}
}