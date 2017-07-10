package com.fabiantarrach.breakinout.game.entity.powerup

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

class ExtraBall(x: Float, y: Float) : PowerUp(x, y) {

	override fun activate(database: EntityDatabase) {
		// TODO: create an extra ball
	}

	override fun render(brush: Brush) {
		shape.render(brush, Color.CORAL)
	}

}