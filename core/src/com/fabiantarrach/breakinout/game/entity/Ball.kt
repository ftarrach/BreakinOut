package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.euclid.Friction
import com.fabiantarrach.breakinout.game.component.euclid.PositionDifference
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.component.gdx.Circle
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.engine.Timespan

class Ball(x: Float, y: Float) : SolidEntity() {

	override val shape = Circle(x, y, radius = 0.025f)
	override var velocity = Velocity(0f, -1f)

	override fun update(delta: Timespan) {
		shape.move(velocity * delta)
		shape.ifOutsideGame(
				left = velocity::mirrorHorizontal,
				right = velocity::mirrorHorizontal,
				top = velocity::mirrorVertical,
				bottom = this::die
		)
		shape.keepInsideGame()
	}

	override fun render(brush: Brush) = shape.render(brush, GdxColor.RED)

	fun bounceOff(difference: PositionDifference) {
		difference.ifSideCollision(
				sideCollision = velocity::mirrorHorizontal,
				normalCollision = velocity::mirrorVertical)
		// TODO: depending on hit position
	}

	fun ifMovingDown(movingDown: () -> Unit) = velocity.ifMovingDown(movingDown)

	fun scrub(other: Friction) = velocity.push(other)

	fun moveRandom() = velocity.randomize()
}