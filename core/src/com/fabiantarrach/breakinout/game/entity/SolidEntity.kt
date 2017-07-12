package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.euclid.PositionDifference
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.component.gdx.Shape
import com.fabiantarrach.breakinout.util.engine.Timespan

abstract class SolidEntity(protected var lifepoints: Int = 1) : Entity {

	protected abstract val shape: Shape
	protected abstract var velocity: Velocity

	override fun update(delta: Timespan) {}

	fun ifOverlaps(other: SolidEntity, action: (PositionDifference) -> Unit) =
			shape.ifOverlaps(other.shape, action)

	fun ifUnder(paddle: SolidEntity, then: () -> Unit, ifNot: () -> Unit) =
		shape.ifUnder(paddle.shape, then, ifNot)

	override fun ifDead(action: () -> Unit) {
		if (lifepoints == 0)
			action()
	}

	fun ifAlive(action: () -> Unit) {
		if (lifepoints != 0)
			action()
	}

	fun hit(died: () -> Unit = {}) {
		lifepoints--
		if (lifepoints == 0)
			died()
	}

	fun die() {
		lifepoints = 0
	}

}