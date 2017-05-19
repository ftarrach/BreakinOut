package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.euclid.Hitbox
import com.fabiantarrach.breakinout.game.system.rendering.RenderingToolbox

abstract class BasicEntity : Entity {

	protected abstract val hitbox: Hitbox

	override fun render(renderingTools: RenderingToolbox) {

	}

}