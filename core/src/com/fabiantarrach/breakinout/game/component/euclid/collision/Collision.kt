package com.fabiantarrach.breakinout.game.component.euclid

interface Collision {
	fun acceptIfCollision(block: Intersection.() -> Unit)
}
