package com.fabiantarrach.breakinout.util.engine

import com.badlogic.gdx.utils.Disposable

abstract class LogicSystem : Disposable {

	protected lateinit var database: EntityDatabase

	abstract fun update(delta: Timespan)

	fun useEntityDatabase(database: EntityDatabase) {
		this.database = database
	}

}