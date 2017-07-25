package com.fabiantarrach.breakinout.game.entity.goodie

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.meta.MovingEntity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

abstract class Goodie(rectangle: Rectangle) :
		MovingEntity(
				Velocity(0f, -0.25f)) {

	override val shape = rectangle
	abstract protected val color: GdxColor

	abstract fun activate(database: EntityDatabase)

	override fun render(renderer: GdxShapeRenderer) =
			shape.render(renderer, color)

	fun renderBlock(renderer: GdxShapeRenderer, shape: Rectangle) {
		shape.render(renderer, color)
	}

}