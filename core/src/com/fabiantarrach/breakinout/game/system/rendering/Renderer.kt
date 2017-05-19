package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.game.entity.Entity

interface Renderer {

	fun render(entities: List<Entity>)

}