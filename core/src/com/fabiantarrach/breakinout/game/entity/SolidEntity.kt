package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.gdx.Shape

abstract class SolidEntity : Entity {

	protected abstract val shape: Shape
	private var dead = false

	fun ifOverlaps(other: SolidEntity, action: () -> Unit) {
		shape.ifOverlaps(other.shape, action)
	}

	override fun ifDead(action: () -> Unit) {
		if (dead)
			action()
	}

	fun ifAlive(action: () -> Unit) {
		if (!dead)
			action()
	}

	open fun die() {
		dead = true
	}

}