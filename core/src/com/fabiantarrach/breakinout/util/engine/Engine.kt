package com.fabiantarrach.breakinout.util.engine

import com.badlogic.gdx.utils.Disposable
import com.fabiantarrach.breakinout.game.entity.Entity
import ktx.collections.gdxArrayOf
import com.badlogic.gdx.utils.Array as GdxArray

abstract class Engine : Disposable {

	// TODO: wrap this collection (Systems?)
	private val systems = gdxArrayOf<LogicSystem>()
	private val entities = EntityDatabase()

	abstract fun buildGame()

	fun addSystem(system: LogicSystem) {
		systems.add(system)
		system.addedToEngine(this)
	}

	fun addEntity(entity: Entity) {
		entities.add(entity)
	}

	fun update(delta: Milliseconds) {
		systems.forEach { it.update(delta) }
	}

	override fun dispose() {
		systems.forEach { it.dispose() }
	}

	fun selectAllEntities() = entities.selectAll()

}