package com.fabiantarrach.breakinout.game.component.euclid

class EntityCollision(private val intersection: Intersection) : Collision {
	override fun acceptIfCollision(block: Intersection.() -> Unit) {
		block(intersection)
	}
}
