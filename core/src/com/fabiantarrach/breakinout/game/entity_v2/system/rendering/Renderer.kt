package com.fabiantarrach.breakinout.game.entity_v2.system.rendering

import com.fabiantarrach.breakinout.game.entity_v2.Entity

interface Renderer {

	fun render(entities: List<Entity>)

}