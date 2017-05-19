package com.fabiantarrach.breakinout.game.component.euclid

class Intersection(private val position: com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Position, private val size: com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Dimension) {

	private fun isAvailable() = size.width() > 0 && size.height() > 0

	fun createCollision(): Collision {
		if (isAvailable())
			return EntityCollision() // TODO: pass parameters into collision to allow user more evaluation
		return NoCollision
	}
}