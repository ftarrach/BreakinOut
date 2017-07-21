package com.fabiantarrach.breakinout.game.meta

interface Resolver<E> {
	fun resolve(one: E, another: E, then: () -> Unit, orElse: () -> Unit, next: () -> Resolver<E>)
}