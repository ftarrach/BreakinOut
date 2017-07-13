package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.util.GdxDisposable

abstract class LogicSystem : GdxDisposable {

	protected lateinit var database: EntityDatabase

	abstract fun update(delta: Timespan)

	// TODO: this is a setter :(
	fun useEntityDatabase(database: EntityDatabase) {
		this.database = database
	}

	override fun dispose() {}

}