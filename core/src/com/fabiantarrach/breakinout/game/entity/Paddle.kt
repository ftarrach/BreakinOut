package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.Dimension
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.euclid.RectangularHitbox
import com.fabiantarrach.breakinout.game.system.rendering.Brush

class Paddle(position: Position) : HardEntity() {

	override val hitbox = RectangularHitbox(position, Dimension(100f, 10f))

	override fun render(brush: Brush) {
		brush.paintWith(Color.WHITE)
		hitbox.render(brush)
	}

}