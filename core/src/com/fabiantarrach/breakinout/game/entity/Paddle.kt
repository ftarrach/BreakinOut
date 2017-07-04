package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.Dimension
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.euclid.RectangularHitbox
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

class Paddle(position: Position) : SolidEntity() {

	override val hitbox = RectangularHitbox(position, Dimension(100f, 10f))

	override fun update(delta: Timespan) {
		// TODO: add velocity to move the paddle.
	}

	override fun render(brush: Brush) {
		brush.useColor(Color.WHITE)
		hitbox.render(brush)
	}

}