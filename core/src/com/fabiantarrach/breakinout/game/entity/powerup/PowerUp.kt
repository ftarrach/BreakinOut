package com.fabiantarrach.breakinout.game.entity.powerup

import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.component.gdx.Rectangle
import com.fabiantarrach.breakinout.game.entity.SolidEntity
import com.fabiantarrach.breakinout.util.engine.EntityDatabase
import com.fabiantarrach.breakinout.util.engine.Timespan

abstract class PowerUp(x: Float, y: Float) : SolidEntity() {

	override val shape = Rectangle(x, y, 0.05f, 0.025f)
	override var velocity = Velocity(0f, -0.01f)

	override fun update(delta: Timespan) {
		shape.move(velocity)
		shape.ifOutsideGame(
				bottom = this::die
		)
	}

	abstract fun activate(database: EntityDatabase)
}