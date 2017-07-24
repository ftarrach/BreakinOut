package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.util.GdxDisposable

abstract class LogicSystem : GdxDisposable {

	protected lateinit var database: EntityDatabase

	fun update(delta: Timespan, database: EntityDatabase) {
		this.database = database
		update(delta)
	}

	abstract fun update(delta: Timespan)

	override fun dispose() {}

}