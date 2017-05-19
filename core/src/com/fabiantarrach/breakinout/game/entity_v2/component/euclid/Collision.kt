package com.fabiantarrach.breakinout.game.entity_v2.component.euclid

interface Collision {
	fun acceptIfCollision(block: Unit.() -> Unit)
}

class EntityCollision : Collision {

	override fun acceptIfCollision(block: Unit.() -> Unit) {
		block(Unit)
	}

}

object NoCollision : Collision {
	override fun acceptIfCollision(block: Unit.() -> Unit) {
	}
}