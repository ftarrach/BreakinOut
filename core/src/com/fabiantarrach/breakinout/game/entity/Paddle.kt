package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Factor
import com.fabiantarrach.breakinout.game.component.MousePosition
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.Timespan

class Paddle : Entity() {

	override val shape = Rectangle(0f, -0.8f, 0.2f, 0.05f)
	private var velocity = Velocity(0f, 0f)

	override fun update(delta: Timespan) {
		val normalizedVelocity = velocity.normalize(delta)
		shape.move(normalizedVelocity)
	}

	override fun render(renderer: GdxShapeRenderer) {
		shape.render(renderer, GdxColor.WHITE)
	}

	fun moveTo(mouse: MousePosition) {
		val velocityToMouse = mouse.moveVelocity()
		velocity = shape.crub(velocityToMouse) * Factor(5f)
	}

	fun bigger() = shape.widen()
	fun smaller() = shape.shorten()

}