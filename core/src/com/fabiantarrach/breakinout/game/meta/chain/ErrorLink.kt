package com.fabiantarrach.breakinout.game.meta.chain

import kotlin.reflect.KClass

class ErrorLink<E: Any>(private val type: KClass<out Chain<E>>) : Handler<E> {

	override fun resolve(one: E, another: E, then: () -> Unit, orElse: () -> Unit, next: () -> Handler<E>) =
			throw NoHandler(type, one, another)

}