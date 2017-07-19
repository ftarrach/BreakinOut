package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.powerup.PowerUp
import com.fabiantarrach.breakinout.game.entity.powerup.PowerUpFactory
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

class Brick(x: Float, y: Float, lifepoints: Int) : Entity(lifepoints) {

	override val shape = Rectangle(x, y, 0.2f, 0.1f)

	override fun render(renderer: GdxShapeRenderer) {
		val color = createColor(Color.GRAY)
		shape.render(renderer, color)
	}

	fun createPowerUp(database: EntityDatabase) {
		val powerUp = createRandomPowerUp()
		database.add(powerUp)
	}

	private fun createRandomPowerUp(): PowerUp {
		val rectangle = shape.createDrop()
		val powerUpFactory = PowerUpFactory()
		return powerUpFactory.createRandom(rectangle)
	}

}