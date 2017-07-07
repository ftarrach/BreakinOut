package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class EntityUpdate : LogicSystem() {

	override fun update(delta: Timespan) =
			database.eachEntity {
				it.update(delta)
			}
}