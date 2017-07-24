package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.game.component.Health
import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.meta.nextTo.NextTo
import com.fabiantarrach.breakinout.game.meta.overlap.Collision
import com.fabiantarrach.breakinout.game.meta.under.Under
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.engine.Entity

abstract class BaseEntity(life: Int = 1): Entity {

	private val lifepoints = Health(life)
	protected abstract val shape: Shape

	override fun ifDead(then: () -> Unit) = lifepoints.ifDead(then)
	override fun ifAlive(then: () -> Unit) = lifepoints.ifAlive(then)
	protected fun hit(ifDied: () -> Unit) = lifepoints.hit(ifDied)
	override fun die() = lifepoints.drain()

	protected fun createLifeColor(base: GdxColor) = lifepoints.createColor(base)

	protected fun ifOverlaps(other: BaseEntity, then: () -> Unit) =
			Collision()
					.process(shape, other.shape, then)

	protected fun ifNextTo(other: BaseEntity, then: () -> Unit, ifNot: () -> Unit) =
			NextTo()
					.process(shape, other.shape, then, ifNot)

	protected fun ifUnder(other: BaseEntity, then: () -> Unit, ifNot: () -> Unit) =
			Under().process(shape, other.shape, then, ifNot)

	protected fun positionRelativeTo(other: BaseEntity) =
			shape.relativeTo(other.shape)

}