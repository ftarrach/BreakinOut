package com.fabiantarrach.breakinout.game.systems

import com.fabiantarrach.breakinout.game.entity.MoveableEntity
import com.fabiantarrach.breakinout.util.Milliseconds


class MoveEntities(private val moveableEntities: Unit.() -> Iterable<MoveableEntity>) : LogicSystem {
	override fun update(delta: Milliseconds) {
		moveableEntities.invoke(Unit).forEach {
			it.move(delta)
		}
	}
}