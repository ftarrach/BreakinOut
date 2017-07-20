package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.screen.Camera

class RenderingSystem(camera: Camera) : LogicSystem() {

	// TODO: other way around: CameraRenderer(FillRenderer)
	private val renderer = FillRenderer(camera)

	override fun update(delta: Timespan) {
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