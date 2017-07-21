package com.fabiantarrach.breakinout.game.meta.chain

import com.fabiantarrach.breakinout.game.component.Shape
import kotlin.reflect.KClass

class ThrowError<T : Chain<*>>(private val type: KClass<T>) : Handler<Shape> {

	override fun resolve(one: Shape, another: Shape, then: () -> Unit, orElse: () -> Unit, next: () -> Handler<Shape>) =
			throw NoHandler(type, one, another)

}