package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.screen.Camera

class RenderingSystem(camera: Camera) : LogicSystem() {

//	private val renderer = LineRenderer(camera)
	private val renderer = FillRenderer(camera)

	override fun update(delta: Timespan) {
//		val entities = database.eachEntity()
//		renderer.render(entities)
		renderer.prepareRendering()
		database.eachEntity {
			renderer.render(it)
		}
		renderer.endRendering()
	}

	override fun dispose() {
		renderer.dispose()
	}
}