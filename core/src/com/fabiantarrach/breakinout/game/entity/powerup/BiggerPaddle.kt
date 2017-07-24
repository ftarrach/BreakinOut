package com.fabiantarrach.breakinout.game.entity.powerup

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

class BiggerPaddle(rectangle: Rectangle) : Goodie(rectangle) {

	override val color: GdxColor = Color.CYAN

	override fun activate(database: EntityDatabase) =
			database.each(Paddle::class) {
				it.bigger()
			}

}