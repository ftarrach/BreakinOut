package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.Dimension
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.euclid.RectangularHitbox
import com.fabiantarrach.breakinout.game.system.rendering.RenderingToolbox

class Paddle(x: Float, y: Float) : BasicEntity() {

	override val hitbox = RectangularHitbox(Position(x, y), Dimension(200f, 20f))

	override fun render(renderingTools: RenderingToolbox) {
		renderingTools.paintWith(Color.WHITE)
		hitbox.render(renderingTools)
	}

}