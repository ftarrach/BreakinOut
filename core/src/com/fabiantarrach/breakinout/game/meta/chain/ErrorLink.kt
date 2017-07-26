package com.fabiantarrach.breakinout.game.meta.chain

import kotlin.reflect.KClass

class ErrorLink<E: Any>(private val type: KClass<out Chain<E>>) : Link<E> {

	override fun resolve(one: E, another: E, then: () -> Unit, orElse: () -> Unit, next: () -> Link<E>) =
			throw NoLinkFound(type, one, another)

}