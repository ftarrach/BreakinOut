package com.fabiantarrach.breakinout.util

import com.fabiantarrach.breakinout.game_neu.component.Lifepoints
import com.fabiantarrach.breakinout.util.engine.Timespan

abstract class Entity(life: Int = 1) {

	private val lifepoints = Lifepoints(life)

	abstract fun update(delta: Timespan)
	abstract fun render(renderer: GdxShapeRenderer)

	fun ifDead(then: () -> Unit) = lifepoints.ifDead(then)
	fun ifAlive(then: () -> Unit) = lifepoints.ifAlive(then)
	fun hit(died: () -> Unit) = lifepoints.hit(died)
	fun die() = lifepoints.drainAll()
	fun createColor(base: GdxColor) = lifepoints.createColor(base)


}