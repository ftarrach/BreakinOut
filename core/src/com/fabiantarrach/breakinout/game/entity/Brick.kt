package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.component.gdx.Rectangle
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.game.util.PowerUpFactory
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.engine.Timespan
import ktx.app.copy

class Brick(x: Float, y: Float, lifepoints: Int) : SolidEntity(lifepoints) {

	override val shape = Rectangle(x, y, 0.2f, 0.1f)
	override var velocity = Velocity(0f, 0f)

	override fun update(delta: Timespan) {}

	override fun render(brush: Brush) =
			ifAlive {
				val color = createColor()
				shape.render(brush, color)
			}

	private fun createColor(): Color =
			(0..lifepoints)
					.fold(GdxColor.GRAY) { color, _ ->
						color.darker()
					}

	fun createPowerUp(): Entity =
			shape.drop { x, y ->
				PowerUpFactory(x, y)
						.createRandom()
			}

	private fun GdxColor.darker(): GdxColor {
		val darkerColor = copy()
		darkerColor.r *= 0.7f
		darkerColor.g *= 0.7f
		darkerColor.b *= 0.7f
		return darkerColor
	}
}
