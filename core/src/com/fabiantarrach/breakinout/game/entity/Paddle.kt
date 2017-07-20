package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Friction
import com.fabiantarrach.breakinout.game.component.MousePosition
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.powerup.PowerUp
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.Timespan

class Paddle : Entity() {

	override val shape = Rectangle(0f, -0.8f, 0.2f, 0.05f)
	private var velocity = Velocity(0f, 0f)

	override fun update(delta: Timespan) {
		val normalizedVelocity = velocity * delta
		shape.move(normalizedVelocity)
	}

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

	fun scrub(ball: Ball) {
		val friction = Friction(0.8f)
		val scrubVelocity = velocity.cease(friction)
		ball.push(scrubVelocity)
	}

	fun bat(ball: Ball) = ball.slamX(velocity)

}
