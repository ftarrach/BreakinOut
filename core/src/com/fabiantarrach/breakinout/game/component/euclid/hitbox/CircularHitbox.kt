package com.fabiantarrach.breakinout.game.component.euclid.hitbox

import com.fabiantarrach.breakinout.game.component.euclid.collision.Collision
import com.fabiantarrach.breakinout.game.component.euclid.collision.NoCollisionAlgorithm
import com.fabiantarrach.breakinout.game.component.gdx.Circle
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush

class CircularHitbox(x: Float, y: Float, radius: Float) : Hitbox {

	private val circle = Circle(x, y, radius)

	private fun overlapsRectangle(other: RectangularHitbox, ifCollision: (Collision) -> Unit) {
		val otherShape = other.toRectangle()
		val intersection = circle.intersect(otherShape)
		val collision = intersection.createCollision()
		collision.acceptIfCollision { ifCollision(collision) }
	}

	private fun overlapsCircle(other: CircularHitbox, ifCollision: (Collision) -> Unit) {
		val otherShape = other.circle
		val intersection = circle.intersect(otherShape)
		val collision = intersection.createCollision()
		collision.acceptIfCollision { ifCollision(collision) }
	}

	override fun ifOverlaps(other: Hitbox, ifCollision: (Collision) -> Unit) {
		if (other is RectangularHitbox) {
			return overlapsRectangle(other, ifCollision)
		}
		if (other is CircularHitbox) {
			return overlapsCircle(other, ifCollision)
		}
		throw NoCollisionAlgorithm(this, other)
	}

	override fun render(brush: Brush) {
		circle.render(brush)
	}

	override fun move(velocity: Velocity) {
		circle.move(velocity)
	}
}