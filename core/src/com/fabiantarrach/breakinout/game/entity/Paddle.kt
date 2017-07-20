package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.MousePosition
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.powerup.PowerUp
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.MovingEntity

class Paddle : MovingEntity() {

	override val shape = Rectangle(0f, -0.8f, 0.2f, 0.05f)

	override fun render(renderer: GdxShapeRenderer) {
		shape.render(renderer, GdxColor.WHITE)
	}

	fun moveTo(mouse: MousePosition) {
		val velocityToMouse = mouse.moveVelocity()
		val crubbed = shape.crub(velocityToMouse)
		velocity = crubbed.faster()
	}

	fun ifOverlaps(powerUp: PowerUp, then: () -> Unit) = super.ifOverlaps(powerUp, then)

	fun bigger() = shape.widen()
	fun smaller() = shape.shorten()

	fun bat(ball: Ball) = ball.slamX(velocity)

	fun scrub(ball: Ball) = super.scrub(ball)

}
