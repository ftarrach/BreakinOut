package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Area
import com.fabiantarrach.breakinout.game.component.Hitbox
import com.fabiantarrach.breakinout.game.renderer.Renderer

// TODO: Refacter whole structure
// Hitbox has an Area in it => -too much logic? +hitbox depends on area
abstract class Entity(protected val area: Area, protected val hitbox: Hitbox<*>) {

	init {
		hitbox.update(area)
	}

	abstract fun render(renderer: Renderer)

	fun overlaps(other: Entity) = hitbox.overlaps(other.hitbox)

	fun isTopOrBottomOf(other: Entity) = area.isTopOrBottomOf(other.area)
	fun isTopOf(other: Entity) = area.isTopOf(other.area)
	fun isLeftOrRightOf(other: Entity) = area.isLeftOrRightOf(other.area)
	fun renderHitbox(renderer: Renderer) = hitbox.render(renderer)

	fun measureRelativePositionX(other: Entity) = (other.area.xCenter() - area.xCenter()) / area.halfWidth()

	fun resolveCollision(other: Entity) = when {
		isTopOf(other) -> resolveCollisionToTop(other)
		else -> TODO("collision resolving other than top")
	}

	private fun resolveCollisionToTop(other: Entity) {
		// TODO: this is a very simple resolver, only adjusting the y value. Make it better
		val x = area.xCenter()
		val otherTop = other.area.yTop()
		val myHalfHight = area.halfHeight()
		val y = otherTop + myHalfHight
		area.setPosition(x, y)
	}
}