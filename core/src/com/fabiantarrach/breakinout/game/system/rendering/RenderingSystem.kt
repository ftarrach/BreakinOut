package com.fabiantarrach.breakinout.game.system.rendering

import com.badlogic.gdx.graphics.OrthographicCamera
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class RenderingSystem(camera: OrthographicCamera) : LogicSystem() {

	private val renderer = LineRenderer(camera)

	override fun update(delta: Timespan) {
		val entities = database.selectAll()
		renderer.render(entities)
	}

	override fun dispose() {
		renderer.dispose()
	}
}