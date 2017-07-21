package com.fabiantarrach.breakinout.game.meta.chain

interface Handler<E> {
	fun resolve(one: E, another: E, then: () -> Unit, orElse: () -> Unit, next: () -> Handler<E>)
}