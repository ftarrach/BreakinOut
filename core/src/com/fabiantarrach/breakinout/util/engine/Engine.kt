package com.fabiantarrach.breakinout.util.engine

import com.badlogic.gdx.utils.Disposable
import com.fabiantarrach.breakinout.game.entity.Entity
import ktx.collections.gdxArrayOf
import com.badlogic.gdx.utils.Array as GdxArray

abstract class Engine : Disposable {

	private val systems = gdxArrayOf<LogicSystem>()
//	protected val entities = EntityManager()

	open fun run() {
		registerSystems(systems)
	}

	protected abstract fun registerSystems(systems: GdxArray<LogicSystem>)

	fun addEntity(entity: Entity) {
//		entities.addEntity(entity)
	}

	fun update(delta: Milliseconds) {
		systems.forEach { it.update(delta) }
	}

	override fun dispose() {
		systems.forEach { it.dispose() }
	}

	fun removeAllEntities() {
//		entities.clear()
	}

}