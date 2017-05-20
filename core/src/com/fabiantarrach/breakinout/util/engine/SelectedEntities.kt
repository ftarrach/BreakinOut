package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.entity.Entity
import com.badlogic.gdx.utils.Array as GdxArray

class SelectedEntities<T : Entity>(private val list: List<T>) {

	constructor(array: GdxArray<T>) : this(array.toList())

	operator fun iterator(): Iterator<T> = list.iterator()

	override fun toString(): String = list.toString()
}