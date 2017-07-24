package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.powerup.Goodie
import com.fabiantarrach.breakinout.game.entity.powerup.GoodieFactory
import com.fabiantarrach.breakinout.game.meta.BaseEntity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.math.Chance

open class Brick(x: Float, y: Float, lifepoints: Int) : BaseEntity(lifepoints) {

	override val shape = Rectangle(x, y, 0.2f, 0.1f)
	protected open val color: GdxColor = GdxColor.DARK_GRAY

	override fun render(renderer: GdxShapeRenderer) {
		val renderedColor = createLifeColor(color)
		shape.render(renderer, renderedColor)
	}

	fun hit(onDrop: (Goodie) -> Unit) =
			super.hit(ifDied = {
				createPowerUp(onDrop)
			})

	private fun createPowerUp(died: (Goodie) -> Unit) {
		val powerUp = generatePowerUp()
		powerUp?.let(died)
	}

	protected open fun generatePowerUp(): Goodie? {
		var newPowerUp: Goodie? = null
		Chance(percent = 33).ifSuccess {
			val powerUpFactory = GoodieFactory()
			val rectangle = shape.createDrop()
			newPowerUp = powerUpFactory.createRandom(rectangle)
		}
		return newPowerUp
	}
}