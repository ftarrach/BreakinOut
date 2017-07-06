package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.collision.Intersection
import com.fabiantarrach.breakinout.game.component.euclid.hitbox.CircularHitbox
import com.fabiantarrach.breakinout.game.component.moving.Angle
import com.fabiantarrach.breakinout.game.component.moving.Speed
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

class Ball(x: Float, y: Float) : SolidEntity() {

	override val hitbox = CircularHitbox(x, y, radius = 0.025f)
	private val velocity = Velocity(Speed(0.5f), Angle(270f))

	override fun update(delta: Timespan) {
		hitbox.move(velocity * delta)
	}

	override fun render(brush: Brush) {
		brush.useColor(Color.RED)
		hitbox.render(brush)
	}

	fun bounceOff() {
		velocity.invertHorizontal()
	}

	fun resolveCollision(intersection: Intersection) {
		// TODO: this is a VERY stupid solution
		hitbox.move(Velocity(Speed(intersection.height()), Angle(90f)))
	}

}