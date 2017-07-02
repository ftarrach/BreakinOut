package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class RenderingSystem(camera: Camera) : LogicSystem() {

//	private val renderer = LineRenderer(camera)
	private val renderer = FillRenderer(camera)

	override fun update(delta: Timespan) {
		val entities = database.selectAll()
		renderer.render(entities)
	}

	override fun dispose() {
		renderer.dispose()
	}
}