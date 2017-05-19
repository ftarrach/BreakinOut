package com.fabiantarrach.breakinout.game.systems

import com.fabiantarrach.breakinout.game.entity.MoveableEntity
import com.fabiantarrach.breakinout.util.Milliseconds

class OuterBounds(private val targets: Unit.() -> Iterable<MoveableEntity>) : LogicSystem {

	override fun update(delta: Milliseconds) {
		// TODO: abstract the game field size and pass it via constructor
//		targets.invoke(Unit).forEach {
//			if (it.leftMost() < -400) {
//				it.position.x = -400 + it.size.width / 2
//				if (it is Ball) {
//					it.velocity.x = -it.velocity.x
//				}
//			} else if (it.leftMost() + it.size.width > 400) {
//				it.position.x = 400 - it.size.width / 2
//				if (it is Ball) {
//					it.velocity.x = -it.velocity.x
//				}
//			}
//		}
	}
}