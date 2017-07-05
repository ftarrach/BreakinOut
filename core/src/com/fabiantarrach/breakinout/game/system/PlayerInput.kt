package com.fabiantarrach.breakinout.game.system

import com.badlogic.gdx.Gdx
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.screen.Camera

class PlayerInput(private val camera: Camera) : LogicSystem() {

	override fun update(delta: Timespan) {
		val x = Gdx.input.x.toFloat()
		val y = Gdx.input.y.toFloat()
		val mouse = camera.getMousePosition(x, y)
		database.each(Paddle::class.java) {
			it.moveTo(mouse)
		}
	}

}

