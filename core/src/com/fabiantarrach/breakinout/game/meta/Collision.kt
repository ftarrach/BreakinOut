package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.util.accept
import com.fabiantarrach.breakinout.util.ifTrue

class Collision {
	private var sideCollision = false
	private var occured = false

	fun occured() {
		occured = true
	}

	fun markSide() {
		occured = true
		sideCollision = true
	}

	fun ifOccured(then: () -> Unit) =
			occured.ifTrue(then)

	fun ifSideCollision(then: () -> Unit, orElse: () -> Unit) =
			sideCollision.accept(then, orElse)
}