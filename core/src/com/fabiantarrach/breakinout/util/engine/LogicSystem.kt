package com.fabiantarrach.breakinout.util.engine

import com.badlogic.gdx.utils.Disposable

abstract class LogicSystem : Disposable {

	private lateinit var engine: Engine

	abstract fun update(delta: Timespan)

	fun selectAll() = engine.selectAllEntities()

	fun addedToEngine(engine: Engine) {
		this.engine = engine
	}
}