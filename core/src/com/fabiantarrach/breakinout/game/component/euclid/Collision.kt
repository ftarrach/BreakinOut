package com.fabiantarrach.breakinout.game.component.euclid

interface Collision {
	fun acceptIfCollision(block: Intersection.() -> Unit)
}

class EntityCollision(private val intersection: Intersection) : Collision {
	override fun acceptIfCollision(block: Intersection.() -> Unit) {
		block(intersection)
	}
}

object NoCollision : Collision {
	override fun acceptIfCollision(block: Intersection.() -> Unit) {
	}
}
