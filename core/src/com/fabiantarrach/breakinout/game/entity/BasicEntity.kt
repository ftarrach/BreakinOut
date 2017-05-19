package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.euclid.Hitbox
import com.fabiantarrach.breakinout.game.system.rendering.RenderingToolbox

abstract class BasicEntity : com.fabiantarrach.breakinout.game.entity_v2.entity.Entity {

	protected abstract val hitbox: Hitbox

	override fun render(renderingTools: RenderingToolbox) {

	}

}