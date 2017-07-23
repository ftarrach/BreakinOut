package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.game.component.Lifepoints
import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.nextTo.NextTo
import com.fabiantarrach.breakinout.game.meta.overlap.Collision
import com.fabiantarrach.breakinout.game.meta.under.Under
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.Timespan

abstract class Entity(life: Int = 1) {

	private val lifepoints = Lifepoints(life)
	protected abstract val shape: Shape

	open fun update(delta: Timespan) {}
	abstract fun render(renderer: GdxShapeRenderer)

	fun ifDead(then: () -> Unit) = lifepoints.ifDead(then)
	fun ifAlive(then: () -> Unit) = lifepoints.ifAlive(then)
	fun hit(died: () -> Unit) = lifepoints.hit(died)
	fun die() = lifepoints.drain()

	protected fun createColor(base: GdxColor) = lifepoints.createColor(base)

	protected fun ifOverlaps(other: Entity, then: () -> Unit) =
			Collision()
					.process(shape, other.shape, then)

	protected fun ifNextTo(other: Entity, then: () -> Unit, ifNot: () -> Unit) =
			NextTo()
					.process(shape, other.shape, then, ifNot)

	protected fun ifUnder(other: Entity, then: () -> Unit, ifNot: () -> Unit) =
			Under().process(shape, other.shape, then, ifNot)

	protected fun positionRelativeTo(other: Entity) =
			shape.relativeTo(other.shape)

}