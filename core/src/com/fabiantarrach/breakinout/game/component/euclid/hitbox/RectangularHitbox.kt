package com.fabiantarrach.breakinout.game.component.euclid.hitbox

import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.euclid.collision.Collision
import com.fabiantarrach.breakinout.game.component.euclid.collision.NoCollisionAlgorithm
import com.fabiantarrach.breakinout.game.component.gdx.Rectangle
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.game.system.rendering.Brush

@Deprecated("we don't need hitboxes, move everything in Rectangle/Circle")
class RectangularHitbox(x: Float, y: Float, width: Float, height: Float) : Hitbox {

	private val rectangle = Rectangle(x, y, width, height)

	@Deprecated("getter")
	fun toRectangle() = rectangle

	override fun render(brush: Brush) = rectangle.render(brush)

	override fun move(velocity: Velocity) = rectangle.move(velocity)

	override fun ifOverlaps(other: Hitbox, ifCollision: (Collision) -> Unit) {
		if (other is CircularHitbox) {
			return other.ifOverlaps(this, ifCollision)
		}
		if (other is RectangularHitbox) {
			val otherShape = other.rectangle
			val intersection = rectangle.intersect(otherShape)
			val collision = intersection.createCollision()
			return collision.acceptIfCollision { ifCollision(collision) }
		}
		throw NoCollisionAlgorithm(this, other)
	}

	@Deprecated("using primitives")
	fun drop(block: (Float, Float) -> Entity): Entity {
		return rectangle.drop(block)
	}

	fun widen() = rectangle.widen()

	fun calculateVelocityFor(mouse: Position) : Velocity =
			rectangle.differenceTo(mouse)

}