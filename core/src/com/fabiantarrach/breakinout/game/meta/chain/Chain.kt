package com.fabiantarrach.breakinout.game.meta.chain

abstract class Chain<E> {

	abstract protected val elements: List<Link<E>>

	fun process(one: E, another: E, then: () -> Unit, orElse: () -> Unit = {}) {
		val iterator = elements.iterator()

		iterator.next()
				.resolve(one, another, then, orElse,
				next = {
					iterator.nextOrEmpty()
				})
	}

	private fun Iterator<Link<E>>.nextOrEmpty(): Link<E> {
		if (hasNext())
			return next()
		return ChainEnd()
	}

}