package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.screen.Camera

class PlayerInput(private val camera: Camera) : LogicSystem() {

	override fun update(delta: Timespan) {
		val mouse = camera.mousePosition()
		database.each(Paddle::class.java) {
			it.moveTo(mouse)
//			it.moveTo(MousePosition(-0.5f, 0f))
		}
	}
}
