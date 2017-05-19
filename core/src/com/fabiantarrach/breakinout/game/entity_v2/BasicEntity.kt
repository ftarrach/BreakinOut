package com.fabiantarrach.breakinout.game.entity_v2

import com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Hitbox
import com.fabiantarrach.breakinout.game.entity_v2.system.rendering.RenderingToolbox

abstract class BasicEntity : Entity {

	protected abstract val hitbox: Hitbox

	override fun render(renderingTools: RenderingToolbox) {

	}

}