package com.fabiantarrach.breakinout.game.component.euclid.collision

object NoCollision : Collision {
	override fun acceptIfCollision(block: Intersection.() -> Unit) {
	}
}
