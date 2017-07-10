package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.component.gdx.Rectangle
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

class Paddle(x: Float, y: Float) : SolidEntity() {

	override val shape = Rectangle(x, y, 0.2f, 0.05f)
	override var velocity = Velocity(0f, 0f)

	override fun update(delta: Timespan) = shape.move(velocity * delta)

	override fun render(brush: Brush) = shape.render(brush, Color.WHITE)

	fun shrink() = shape.shorten()

	fun grow() = shape.widen()

	fun scrub(ball: Ball) = ball.scrub(velocity * 0.5f)

	fun moveTo(mouse: Position) {
		velocity = shape.calculateVelocityTo(mouse)
	}
}