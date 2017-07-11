package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.euclid.PositionDifference
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.component.gdx.Circle
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.engine.Timespan

class Ball(x: Float, y: Float) : SolidEntity() {

	override val shape = Circle(x, y, radius = 0.025f)
	override var velocity = Velocity(0f, -0.5f)

	override fun update(delta: Timespan) {
		shape.move(velocity * delta)
		shape.ifOutsideGame(
				left = velocity::invertHorizontal,
				right = velocity::invertHorizontal,
				top = velocity::invertVertical,
				bottom = this::die
		)
		shape.keepInsideGame()
	}

	override fun render(brush: Brush) =
			shape.render(brush, GdxColor.RED)

	fun bounceOff(difference: PositionDifference) {
		velocity.invertVertical()
		velocity.spin(difference)
		// TODO: also use velocity of paddle
	}

	fun ifMovingDown(movingDown: () -> Unit) =
			velocity.ifMovingDown(movingDown)

	fun scrub(other: Velocity) {
		velocity.add(other)
	}

	fun moveToRandom() {
		velocity.randomize()
	}
}