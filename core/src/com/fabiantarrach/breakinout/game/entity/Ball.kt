package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.CircleSize
import com.fabiantarrach.breakinout.game.component.euclid.CircularHitbox
import com.fabiantarrach.breakinout.game.component.euclid.Hitbox
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.system.rendering.Brush

class Ball(position: Position) : HardEntity() {

	override val hitbox: Hitbox = CircularHitbox(position, CircleSize(5f))

	override fun render(brush: Brush) {
		brush.paintWith(Color.RED)
		hitbox.render(brush)
	}

}