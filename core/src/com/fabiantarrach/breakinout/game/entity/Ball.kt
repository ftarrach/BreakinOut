package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.CircleSize
import com.fabiantarrach.breakinout.game.component.euclid.CircularHitbox
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.moving.Angle
import com.fabiantarrach.breakinout.game.component.moving.Speed
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

class Ball(position: Position) : HardEntity() {

	override val hitbox = CircularHitbox(position, CircleSize(5f))
	private val velocity = Velocity(Speed(10f), Angle(270f))

	override fun update(delta: Timespan) {
		hitbox.move(velocity * delta)
	}

	override fun render(brush: Brush) {
		brush.paintWith(Color.RED)
		hitbox.render(brush)
	}

}