package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.util.engine.Entity
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.GdxShapeType
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.screen.Camera

class RenderingSystem(private val camera: Camera) : LogicSystem() {

	private val renderer = GdxShapeRenderer()

	override fun update(delta: Timespan) {
		camera.projectOn(renderer)
		renderer.begin(GdxShapeType.Filled)
		database.eachEntity(this::renderEntity)
		renderer.end()
	}

	private fun renderEntity(it: Entity) = it.render(renderer)

	override fun dispose() {
		renderer.dispose()
	}
}