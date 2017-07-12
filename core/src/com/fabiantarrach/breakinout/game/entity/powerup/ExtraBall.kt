package com.fabiantarrach.breakinout.game.entity.powerup

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

class ExtraBall(x: Float, y: Float) : PowerUp(x, y) {

	override fun activate(database: EntityDatabase) {
		val newBall = Ball(0f, 0f)
		newBall.moveRandom()
		database.add(newBall)
	}

	override fun render(brush: Brush) {
		shape.render(brush, GdxColor.CORAL)
	}

}