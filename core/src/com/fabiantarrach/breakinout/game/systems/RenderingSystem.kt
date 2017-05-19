package com.fabiantarrach.breakinout.game.systems

import com.badlogic.gdx.graphics.OrthographicCamera
import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.game.renderer.HitboxRenderer
import com.fabiantarrach.breakinout.util.Milliseconds

class RenderingSystem(private val camera: OrthographicCamera, private val entities: Iterable<Entity>) : LogicSystem {

	private val renderer = HitboxRenderer()

	override fun update(delta: Milliseconds) {
		renderer.useCamera(camera)
		renderer.begin()
		entities.forEach {
			it.renderHitbox(renderer)
		}
		renderer.end()
	}

	override fun dispose() {
		renderer.dispose()
	}
}