package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.util.GdxArray


class SystemDatabase {
	private val systems = GdxArray<LogicSystem>()

	fun addSystem(system: LogicSystem) {
		systems.add(system)
	}

	fun each(action: (LogicSystem) -> Unit) =
		systems.forEach(action)

	operator fun iterator() = systems.iterator()
}