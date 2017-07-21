package com.fabiantarrach.breakinout.game.meta.pipe

abstract class Pipe<E> {

	abstract protected val elements: List<Resolver<E>>

	fun process(one: E, another: E, then: () -> Unit, orElse: () -> Unit = {}) {
		val iterator = elements.iterator()
		iterator.next().resolve(one, another, then, orElse,
				next = iterator::next)
	}

}