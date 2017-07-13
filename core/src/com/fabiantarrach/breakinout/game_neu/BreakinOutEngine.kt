package com.fabiantarrach.breakinout.game_neu

import com.fabiantarrach.breakinout.game_neu.level.Level1
import com.fabiantarrach.breakinout.game_neu.system.*
import com.fabiantarrach.breakinout.game_neu.system.rendering.RenderingSystem
import com.fabiantarrach.breakinout.util.engine.Engine
import com.fabiantarrach.breakinout.util.screen.Camera
import com.fabiantarrach.breakinout.util.screen.ScreenState

class BreakinOutEngine(private val screenState: ScreenState,
                       private val camera: Camera) : Engine() {

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
				GameOver(screenState))
		addSystem(
				RenderingSystem(camera))
	}
}