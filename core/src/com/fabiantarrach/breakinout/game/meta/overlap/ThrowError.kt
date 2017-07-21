package com.fabiantarrach.breakinout.game.meta.overlap

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.chain.AlgorithmNotFound
import com.fabiantarrach.breakinout.game.meta.chain.Handler

class ThrowError : Handler<Shape> {
	override fun resolve(one: Shape, another: Shape, then: () -> Unit, orElse: () -> Unit, next: () -> Handler<Shape>) {
		throw AlgorithmNotFound(one, another)
	}
}