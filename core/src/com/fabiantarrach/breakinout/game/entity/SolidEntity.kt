package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.euclid.collision.Intersection
import com.fabiantarrach.breakinout.game.component.euclid.hitbox.Hitbox

abstract class SolidEntity : Entity {

	protected abstract val hitbox: Hitbox
	private var dead = false

	fun ifOverlaps(other: SolidEntity, ifCollision: (Intersection) -> Unit) {
		hitbox.ifOverlaps(other.hitbox) {
			collision -> collision.acceptIfCollision(ifCollision)
		}
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