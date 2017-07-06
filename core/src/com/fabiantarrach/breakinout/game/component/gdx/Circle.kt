package com.fabiantarrach.breakinout.game.component.gdx

import com.badlogic.gdx.math.Intersector
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.GdxCircle

class Circle(x: Float, y: Float, radius: Float) : Shape {

	private val circle = GdxCircle(x, y, radius)

	override fun render(brush: Brush) {
		brush.drawCircle(circle.x, circle.y, circle.radius)
	}

	override fun ifOverlaps(other: Shape, action: () -> Unit) {
		if (other is Circle) {
			ifOverlapsCircle(other, action)
			return
		}
		if (other is Rectangle) {
			other.ifOverlaps(this, action)
			return
		}
		throw NoCollisionAlgorithmFound(this, other)
	}

	private fun ifOverlapsCircle(other: Circle, action: () -> Unit) {
		if (Intersector.overlaps(circle, other.circle))
			action()
	}

	fun giveCircle(block: (GdxCircle) -> Unit) {
		block(circle)
	}

	override fun move(velocity: Velocity) {
		velocity.move(circle)
	}

}