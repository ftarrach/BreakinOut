package com.fabiantarrach.breakinout.game.entity.powerup

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

class BiggerPaddle(x: Float, y: Float) : PowerUp(x, y) {

	override fun render(brush: Brush) {
		brush.useColor(Color.CYAN)
		shape.render(brush)
	}

	override fun activate(database: EntityDatabase) {
		database.each(Paddle::class.java) {
			it.bigger()
		}
	}

}