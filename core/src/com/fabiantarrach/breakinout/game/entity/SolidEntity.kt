package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.euclid.Collision
import com.fabiantarrach.breakinout.game.component.euclid.Hitbox
import com.fabiantarrach.breakinout.game.component.euclid.Intersection

abstract class SolidEntity : Entity {

	protected abstract val hitbox: Hitbox

	fun overlaps(other: SolidEntity, ifCollision: (Intersection) -> Unit) {
		val acceptor: (Collision) -> Unit = {
			collision -> collision.acceptIfCollision(ifCollision)
		}
		hitbox.overlaps(other.hitbox, acceptor)
	}

}