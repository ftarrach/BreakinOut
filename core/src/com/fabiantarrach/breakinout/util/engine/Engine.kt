package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.meta.Entity
import com.fabiantarrach.breakinout.util.GdxDisposable

abstract class Engine : GdxDisposable {

	private val systems = SystemDatabase()
	private val entities = EntityDatabase()

	abstract fun buildGame()

	fun addSystem(system: LogicSystem) =
			systems.addSystem(system)

	fun addEntity(entity: Entity) =
			entities.add(entity)

	fun update(delta: Timespan) {
		for (system in systems)
			system.update(delta, entities)
	}

	override fun dispose() {
		for (system in systems)
			system.dispose()
	}
}