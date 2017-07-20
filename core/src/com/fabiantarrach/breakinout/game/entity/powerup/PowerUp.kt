package com.fabiantarrach.breakinout.game.entity.powerup

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.MovingEntity
import com.fabiantarrach.breakinout.util.engine.EntityDatabase

abstract class PowerUp(rectangle: Rectangle) :
		MovingEntity(
				Velocity(0f, -0.25f)) {

	override val shape = rectangle
	abstract protected val color: GdxColor

	abstract fun activate(database: EntityDatabase)

	override fun render(renderer: GdxShapeRenderer) =
			shape.render(renderer, color)

}