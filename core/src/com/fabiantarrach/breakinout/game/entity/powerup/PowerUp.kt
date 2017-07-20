package com.fabiantarrach.breakinout.game.entity.powerup

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.EntityDatabase
import com.fabiantarrach.breakinout.util.engine.Timespan

abstract class PowerUp(rectangle: Rectangle) : Entity() {

	override val shape = rectangle
	abstract protected val color: GdxColor

	abstract fun activate(database: EntityDatabase)

	override fun render(renderer: GdxShapeRenderer) =
			shape.render(renderer, color)

	override fun update(delta: Timespan) =
			shape.move(Velocity(0f, -0.25f) * delta)
}