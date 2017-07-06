package com.fabiantarrach.breakinout.game.component.euclid.collision

interface Collision {
	fun acceptIfCollision(block: Intersection.() -> Unit)
}
