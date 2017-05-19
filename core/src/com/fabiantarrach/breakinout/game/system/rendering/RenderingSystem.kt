package com.fabiantarrach.breakinout.game.system.rendering

import com.badlogic.gdx.graphics.OrthographicCamera
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Milliseconds

class RenderingSystem(camera: OrthographicCamera) : LogicSystem {

	private val renderer = LineRenderer(camera)

	override fun update(delta: Milliseconds) {
		renderer.render(/* TODO: insert list of enteties here */emptyList())
	}

	override fun dispose() {
		renderer.dispose()
	}
}