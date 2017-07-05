package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.euclid.hitbox.RectangularHitbox
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

class Paddle(x: Float, y: Float) : SolidEntity() {

	override val hitbox = RectangularHitbox(x, y, 0.2f, 0.05f)
	private var velocity = Velocity(0f, 0f)

	override fun update(delta: Timespan) {
		hitbox.move(velocity * delta)
	}

	override fun render(brush: Brush) {
		brush.useColor(Color.WHITE)
		hitbox.render(brush)
	}

	fun bigger() = hitbox.widen()

	fun moveTo(mouse: Position) {
		velocity = hitbox.calculateVelocityFor(mouse)
	}

}