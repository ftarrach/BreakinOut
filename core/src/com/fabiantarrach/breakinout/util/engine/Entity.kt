package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.util.GdxShapeRenderer

interface Entity {
	fun update(delta: Timespan) {}
	fun render(renderer: GdxShapeRenderer)

	fun ifDead(then: () -> Unit)
	fun ifAlive(then: () -> Unit)
	fun die()
}