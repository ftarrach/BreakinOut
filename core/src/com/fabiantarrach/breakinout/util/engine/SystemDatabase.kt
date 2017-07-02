package com.fabiantarrach.breakinout.util.engine

import com.badlogic.gdx.utils.Array as GdxArray

class SystemDatabase {
	private val systems = GdxArray<LogicSystem>()

	fun addSystem(system: LogicSystem) {
		systems.add(system)
	}

	operator fun iterator() = systems.iterator()
}