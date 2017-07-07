package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.component.gdx.Circle
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

class Ball(x: Float, y: Float) : SolidEntity() {

	override val shape = Circle(x, y, radius = 0.025f)
	private val velocity = Velocity(0f, -0.5f)

	override fun update(delta: Timespan) {
		shape.move(velocity * delta)
		shape.ifOutsideGame(
				left = velocity::invertHorizontal,
				right = velocity::invertHorizontal,
				top = velocity::invertVertical,
				bottom = this::die
		)
	}

	override fun render(brush: Brush) {
		shape.render(brush, Color.RED)
	}

	// TODO: think about, how the collision happend, left/right side? top? bottom?
	fun bounceOff() {
		velocity.invertVertical()
	}

	fun ifMovingDown(movingDown: () -> Unit) {
		velocity.ifMovingDown(movingDown, {})
	}

}