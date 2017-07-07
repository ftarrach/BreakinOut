package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.util.GdxArray


class SystemDatabase {
	private val systems = GdxArray<LogicSystem>()

	fun addSystem(system: LogicSystem) {
		systems.add(system)
	}

	operator fun iterator() = systems.iterator()
}