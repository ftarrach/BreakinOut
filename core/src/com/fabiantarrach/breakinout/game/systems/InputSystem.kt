package com.fabiantarrach.breakinout.game.systems

import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.math.Vector3
import com.fabiantarrach.breakinout.game.entity.MoveableEntity
import com.fabiantarrach.breakinout.util.Milliseconds

class InputSystem(private val camera: Camera, private val target: Unit.() -> Iterable<MoveableEntity>) : InputAdapter(), LogicSystem {

	private val mousePosition = Vector3()

	override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
		updateMousePosition(screenX, screenY)
		return true
	}

	override fun update(delta: Milliseconds) {
		target.invoke(Unit).forEach {
			it.moveToX(mousePosition.x)
		}
	}

	private fun updateMousePosition(screenX: Int, screenY: Int) {
		mousePosition.set(screenX.toFloat(), screenY.toFloat(), 0f)
		camera.unproject(mousePosition)
	}
}