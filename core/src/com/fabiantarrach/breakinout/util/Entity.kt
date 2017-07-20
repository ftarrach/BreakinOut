package com.fabiantarrach.breakinout.util

import com.fabiantarrach.breakinout.game.component.Lifepoints
import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.util.engine.Timespan

abstract class Entity(life: Int = 1) {

	private val lifepoints = Lifepoints(life)
	protected abstract val shape: Shape

	open fun update(delta: Timespan) {}
	abstract fun render(renderer: GdxShapeRenderer)

	fun ifDead(then: () -> Unit) = lifepoints.ifDead(then)
	fun ifAlive(then: () -> Unit) = lifepoints.ifAlive(then)
	fun hit(died: () -> Unit) = lifepoints.hit(died)
	fun die() = lifepoints.drainAll()

	protected fun createColor(base: GdxColor) = lifepoints.createColor(base)

	protected fun ifOverlaps(other: Entity, then: () -> Unit) =
			shape.ifOverlaps(other.shape, then)

	protected fun ifNextTo(other: Entity, then: () -> Unit, ifNot: () -> Unit) =
			shape.ifNextTo(other.shape, then, ifNot)

	protected fun ifUnder(other: Entity, then: () -> Unit, ifNot: () -> Unit) =
			shape.ifUnder(other.shape, then, ifNot)

}