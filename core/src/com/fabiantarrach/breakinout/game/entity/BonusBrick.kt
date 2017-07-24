package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.powerup.Goodie
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.math.Chance

class BonusBrick(x: Float, y: Float, goodieSupplier: (Rectangle) -> Goodie) : Brick(x, y, lifepoints = 1) {

	private val goodie: Goodie

	init {
		val drop = shape.createDrop()
		goodie = goodieSupplier(drop)
	}

	override fun render(renderer: GdxShapeRenderer) =
			goodie.renderBlock(renderer, shape)

	override fun generatePowerUp(): Goodie? {
		var newGoodie: Goodie? = null
		Chance(95).ifSuccess {
			newGoodie = goodie
		}
		return newGoodie
	}

}