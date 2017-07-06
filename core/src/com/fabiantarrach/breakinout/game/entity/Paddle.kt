package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.gdx.Rectangle
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

class Paddle(x: Float, y: Float) : SolidEntity() {

	override val shape = Rectangle(x, y, 0.2f, 0.05f)
	private var velocity = Velocity(0f, 0f)

	override fun update(delta: Timespan) {
		shape.move(velocity * delta)
	}

	override fun render(brush: Brush) {
		brush.useColor(Color.WHITE)
		shape.render(brush)
	}

	fun bigger() = shape.widen()

	fun moveTo(mouse: Position) {
		velocity = shape.differenceTo(mouse)
	}

}