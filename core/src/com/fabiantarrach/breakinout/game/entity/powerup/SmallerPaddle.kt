package com.fabiantarrach.breakinout.game.entity.powerup

import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

class SmallerPaddle(rectangle: Rectangle) : PowerUp(rectangle) {
	override val color: GdxColor = GdxColor.BLUE

	override fun activate(database: EntityDatabase) {
		database.each(Paddle::class) {
			it.smaller()
		}
	}

}