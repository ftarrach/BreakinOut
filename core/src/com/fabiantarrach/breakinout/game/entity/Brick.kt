package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.component.gdx.Rectangle
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.game.util.PowerUpFactory
import com.fabiantarrach.breakinout.util.engine.Timespan

class Brick(x: Float, y: Float) : SolidEntity() {

	override val shape = Rectangle(x, y, 0.2f, 0.1f)
	override var velocity = Velocity(0f, 0f)

	override fun update(delta: Timespan) {}

	override fun render(brush: Brush) {
		ifAlive {
			shape.render(brush, Color.GRAY)
		}
	}

	fun createPowerUp(): Entity {
		return shape.drop { x, y ->
			PowerUpFactory(x, y)
					.createRandom()
		}
	}
}