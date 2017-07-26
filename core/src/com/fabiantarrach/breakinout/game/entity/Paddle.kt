package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Friction
import com.fabiantarrach.breakinout.game.component.MousePosition
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.goodie.Goodie
import com.fabiantarrach.breakinout.game.meta.MovingEntity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.math.Y

class Paddle : MovingEntity() {

	override val shape = Rectangle(0f, -0.8f, 0.2f, 0.05f)
	private val friction = Friction(0.8f)

	override fun render(renderer: GdxShapeRenderer) =
			shape.render(renderer, GdxColor.WHITE)

	override public fun moveTo(mouse: MousePosition) =
			super.moveTo(mouse)

	fun ifOverlaps(powerUp: Goodie, then: () -> Unit) =
			super.ifOverlaps(powerUp, then)

	fun bigger() =
			shape.widen()

	fun smaller() =
			shape.shorten()

	fun bat(other: Ball) =
			super.bat(other)

	fun scrub(ball: Ball) =
			super.scrub(ball, friction)

	fun push(ball: Ball) {
		val relative = positionRelativeTo(ball)
		var pushVelocity = Velocity(relative, Y(0f))
		ball.ifMovingLeft {
			pushVelocity = pushVelocity.invert()
		}
		ball.push(pushVelocity)
	}

}
