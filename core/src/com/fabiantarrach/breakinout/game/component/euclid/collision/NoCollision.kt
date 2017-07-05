package com.fabiantarrach.breakinout.game.component.euclid

object NoCollision : Collision {
	override fun acceptIfCollision(block: Intersection.() -> Unit) {
	}
}
