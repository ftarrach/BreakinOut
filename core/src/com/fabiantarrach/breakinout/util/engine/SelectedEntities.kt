package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.entity.Entity
import com.badlogic.gdx.utils.Array as GdxArray

class SelectedEntities(private val list: GdxArray<Entity>) {

	operator fun iterator(): Iterator<Entity> = list.iterator()

	override fun toString(): String = list.toString()
}