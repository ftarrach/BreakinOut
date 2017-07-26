package com.fabiantarrach.breakinout.game.meta.chain

class ChainEnd<E> : Link<E> {
	override fun resolve(one: E, another: E, then: () -> Unit, orElse: () -> Unit, next: () -> Link<E>) {}
}