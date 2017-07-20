package com.fabiantarrach.breakinout.game.meta

class Collision {
	private var sideCollision = false
	private var occured = false

	fun reset() {
		sideCollision = false
		occured = false
	}

	fun occured() {
		occured = true
	}

	fun markSide() {
		occured = true
		sideCollision = true
	}

	fun ifOccured(then: () -> Unit) {
		if (occured)
			then()
	}

	fun ifSideCollision(then: () -> Unit, orElse: () -> Unit) {
		if (sideCollision)
			return then()
		orElse()
	}
}