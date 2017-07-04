package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.Dimension
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.euclid.RectangularHitbox
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

class Brick(position: Position) : SolidEntity() {

	override val hitbox = RectangularHitbox(position, Dimension(0.2f, 0.1f))

	override fun update(delta: Timespan) {}

	override fun render(brush: Brush) {
		ifAlive {
			brush.useColor(Color.GRAY)
			hitbox.render(brush)
		}
	}

}