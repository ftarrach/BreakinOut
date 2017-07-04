package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.euclid.Hitbox
import com.fabiantarrach.breakinout.game.component.euclid.Intersection

abstract class SolidEntity : Entity {

	protected abstract val hitbox: Hitbox
	private var dead = false

	fun overlaps(other: SolidEntity, ifCollision: (Intersection) -> Unit) {
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

	fun die() {
		dead = true
	}

}