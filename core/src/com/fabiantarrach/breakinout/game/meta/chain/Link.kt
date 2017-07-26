package com.fabiantarrach.breakinout.game.meta.chain

interface Link<E> {
	fun resolve(one: E, another: E, then: () -> Unit, orElse: () -> Unit, next: () -> Link<E>)
}