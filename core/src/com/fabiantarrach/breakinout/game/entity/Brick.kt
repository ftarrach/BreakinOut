package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.gdx.Rectangle
import com.fabiantarrach.breakinout.game.entity.powerup.BiggerPaddle
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

class Brick(x: Float, y: Float) : SolidEntity() {

	override val shape = Rectangle(x, y, 0.2f, 0.1f)

	override fun update(delta: Timespan) {}

	override fun render(brush: Brush) {
		ifAlive {
			brush.useColor(Color.GRAY)
			shape.render(brush)
		}
	}

	fun createPowerUp(): Entity {
		// TODO: different powerups
		return shape.drop { x, y ->
			BiggerPaddle(x, y)
		}
	}

}