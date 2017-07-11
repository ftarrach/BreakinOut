package com.fabiantarrach.breakinout.game.component.euclid

class PositionDifference(private val relativeX: Float, private val sideCollision: Boolean) {

	fun ifSideCollision(sideCollision: () -> Unit, normalCollision: () -> Unit = {}) {
		if (this.sideCollision) {
			sideCollision()
			return
		}
		normalCollision()
	}

}

val NoPositionDifference = PositionDifference(0f, false)