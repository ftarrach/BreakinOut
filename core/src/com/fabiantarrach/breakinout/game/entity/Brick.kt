package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.hitbox.RectangularHitbox
import com.fabiantarrach.breakinout.game.entity.powerup.BiggerPaddle
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

class Brick(x: Float, y: Float) : SolidEntity() {

	override val hitbox = RectangularHitbox(x, y, 0.2f, 0.1f)

	override fun update(delta: Timespan) {}

	override fun render(brush: Brush) {
		ifAlive {
			brush.useColor(Color.GRAY)
			hitbox.render(brush)
		}
	}

	fun createPowerUp(): Entity {
		// TODO: different powerups
		return hitbox.drop { x, y ->
			BiggerPaddle(x, y)
		}
	}

}