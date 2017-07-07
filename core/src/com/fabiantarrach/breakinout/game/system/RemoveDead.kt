package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class RemoveDead : LogicSystem() {

	override fun update(delta: Timespan) =
			database.eachEntity {
				it.removeIfDead()
			}

	private fun Entity.removeIfDead() =
			ifDead {
				database.remove(this)
			}

}