package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.Timespan

interface Entity {
	fun update(delta: Timespan) {}
	fun render(renderer: GdxShapeRenderer)

	fun ifDead(then: () -> Unit)
	fun ifAlive(then: () -> Unit)
	fun die()
}