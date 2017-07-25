package com.fabiantarrach.breakinout.game.entity.goodie

import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

class SmallerPaddle(rectangle: Rectangle) : Goodie(rectangle) {
	override val color: GdxColor = GdxColor.BLUE

	override fun activate(database: EntityDatabase) =
			database.each(Paddle::class) {
				it.smaller()
				Reset(it).start()
			}

	private class Reset(private val paddle: Paddle) : Thread() {
		override fun run() {
			Thread.sleep(5000)
			paddle.bigger()
		}
	}

}