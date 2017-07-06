package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.gdx.Circle
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

class Ball(x: Float, y: Float) : SolidEntity() {

	override val shape = Circle(x, y, radius = 0.025f)
	private val velocity = Velocity(0f, -0.5f)

	override fun update(delta: Timespan) {
		shape.move(velocity * delta)
	}

	override fun render(brush: Brush) {
		brush.useColor(Color.RED)
		shape.render(brush)
	}

	fun bounceOff() {
		velocity.invertHorizontal()
	}

//	fun resolveCollision(intersection: Intersection) {
		// TODO: this is a VERY stupid solution
//		shape.move(Velocity(Speed(intersection.height()), Angle(90f)))
//	}

}