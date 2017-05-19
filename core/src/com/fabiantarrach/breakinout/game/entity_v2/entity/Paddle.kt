package com.fabiantarrach.breakinout.game.entity_v2.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.entity_v2.BasicEntity
import com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Dimension
import com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Position
import com.fabiantarrach.breakinout.game.entity_v2.component.euclid.RectangularHitbox
import com.fabiantarrach.breakinout.game.entity_v2.system.rendering.RenderingToolbox

class Paddle(x: Float, y: Float) : BasicEntity() {

	override val hitbox = RectangularHitbox(Position(x, y), Dimension(200f, 20f))

	override fun render(renderingTools: RenderingToolbox) {
		renderingTools.paintWith(Color.WHITE)
		hitbox.render(renderingTools)
	}

}