package com.fabiantarrach.breakinout.game.meta.chain

abstract class Chain<E> {

	abstract protected val links: List<Link<E>>

	fun process(one: E, another: E, then: () -> Unit, orElse: () -> Unit = {}) {
		val iterator = links.iterator()
		iterator.nextLink()
				.resolve(one, another, then, orElse,
				next = {
					iterator.nextLink()
				})
	}

	private fun Iterator<Link<E>>.nextLink(): Link<E> {
		if (hasNext())
			return next()
		return ChainEnd()
	}
}