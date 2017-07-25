package com.fabiantarrach.breakinout.game.entity.goodie

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

class ExtraBall(rectangle: Rectangle) : Goodie(rectangle) {
	override val color: GdxColor = Color.ORANGE

	override fun activate(database: EntityDatabase) {
		val velocity = Velocity(1f, 0f)
		velocity.randomizeAngle()
		val ball = Ball(0f, 0f, velocity)
		database.add(ball)
	}
}