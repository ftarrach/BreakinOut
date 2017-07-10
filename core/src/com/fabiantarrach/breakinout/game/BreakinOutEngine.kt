package com.fabiantarrach.breakinout.game

import com.fabiantarrach.breakinout.game.level.Level1
import com.fabiantarrach.breakinout.game.system.*
import com.fabiantarrach.breakinout.game.system.rendering.RenderingSystem
import com.fabiantarrach.breakinout.util.engine.Engine
import com.fabiantarrach.breakinout.util.screen.Camera

class BreakinOutEngine(private val camera: Camera) : Engine() {

	override fun buildGame() {
		Level1(this)
				.build()
		addSystem(
				PlayerInput(camera))
		addSystem(
				EntityUpdate())
		addSystem(
				BallPaddleCollision())
		addSystem(
				BallBrickCollision())
		addSystem(
				PaddlePowerUpCollision())
		addSystem(
				RemoveDead())
		addSystem(
				GameOver())
		addSystem(
				RenderingSystem(camera))
	}
}