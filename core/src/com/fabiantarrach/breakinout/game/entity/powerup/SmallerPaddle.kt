package com.fabiantarrach.breakinout.game.entity.powerup

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

class SmallerPaddle(x: Float, y: Float) : PowerUp(x, y) {

	override fun render(brush: Brush) {
		shape.render(brush, Color.BLUE)
	}

	override fun activate(database: EntityDatabase) {
		database.each(Paddle::class.java) {
			it.shrink()
		}
	}

}