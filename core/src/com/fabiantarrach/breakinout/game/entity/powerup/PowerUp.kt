package com.fabiantarrach.breakinout.game.entity.powerup

import com.fabiantarrach.breakinout.game.component.euclid.hitbox.RectangularHitbox
import com.fabiantarrach.breakinout.game.component.moving.Angle
import com.fabiantarrach.breakinout.game.component.moving.Speed
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.entity.SolidEntity
import com.fabiantarrach.breakinout.util.engine.EntityDatabase
import com.fabiantarrach.breakinout.util.engine.Timespan

abstract class PowerUp(x: Float, y: Float) : SolidEntity() {

	override val hitbox = RectangularHitbox(x, y, 0.05f, 0.025f)
	private val velocity = Velocity(Speed(0.0025f), Angle(270f))

	override fun update(delta: Timespan) {
		hitbox.move(velocity)
	}

	abstract fun activate(database: EntityDatabase)
}