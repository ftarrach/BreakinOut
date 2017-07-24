package com.fabiantarrach.breakinout.game.entity.powerup

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

class ExtraBall(rectangle: Rectangle) : Goodie(rectangle) {
	override val color: GdxColor = Color.ORANGE

	override fun activate(database: EntityDatabase) {
		val ball = Ball(0f, 0f)
		ball.moveRandom()
		database.add(ball)
	}
}