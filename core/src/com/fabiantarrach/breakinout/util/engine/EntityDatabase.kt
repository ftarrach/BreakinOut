package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.util.clone
import ktx.collections.gdxArrayOf

class EntityDatabase {

	private val entities = gdxArrayOf<Entity>()

	fun add(entity: Entity) = entities.add(entity)

	fun selectAll() = SelectedEntities(entities.clone())

}