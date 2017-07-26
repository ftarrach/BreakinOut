package com.fabiantarrach.breakinout.game.meta.chain

class EndLink<E> : Handler<E> {
	override fun resolve(one: E, another: E, then: () -> Unit, orElse: () -> Unit, next: () -> Handler<E>) {}
}