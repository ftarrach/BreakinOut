package com.fabiantarrach.breakinout.util.engine

import com.badlogic.gdx.utils.Array as GdxArray

class Systems {
	private val systems = GdxArray<LogicSystem>()

	fun addSystem(system: LogicSystem) {
		systems.add(system)
	}

	fun iterator() = systems.iterator()
}