package com.fabiantarrach.breakinout.game.component.euclid

class Intersection(private val position: Position, private val size: Dimension) {

	private fun isAvailable() = size.width() > 0 && size.height() > 0

	fun createCollision(): Collision {
		if (isAvailable())
			return EntityCollision() // TODO: pass parameters into collision to allow user more evaluation
		return NoCollision
	}
}