package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.euclid.PositionDifference
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.component.gdx.Shape

abstract class SolidEntity(private var livepoints: Int = 1) : Entity {

	protected abstract val shape: Shape
	protected abstract var velocity: Velocity

	fun ifOverlaps(other: SolidEntity, action: (PositionDifference) -> Unit) {
		shape.ifOverlaps(other.shape, action)
	}

	override fun ifDead(action: () -> Unit) {
		if (livepoints == 0)
			action()
	}

	fun ifAlive(action: () -> Unit) {
		if (livepoints != 0)
			action()
	}

	fun hit() {
		livepoints--
	}

	fun die() {
		livepoints = 0
	}

}