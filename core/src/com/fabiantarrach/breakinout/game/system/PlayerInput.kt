package com.fabiantarrach.breakinout.game.system

import com.badlogic.gdx.Gdx
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.GdxVector3
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.screen.Camera

class PlayerInput(private val camera: Camera) : LogicSystem() {

	override fun update(delta: Timespan) {
		val x = Gdx.input.x.toFloat()
		val y = Gdx.input.y.toFloat()
		val mouseScreen = GdxVector3(x, y, 0f)
		camera.unprojectMouse(mouseScreen) { mouseGame ->
			movePaddles(mouseGame)
		}
	}

	private fun movePaddles(mouseGame: Position) =
		database.each(Paddle::class.java) {
			it.moveTo(mouseGame)
		}
}
