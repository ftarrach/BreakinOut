package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.game.component.gdx.Circle
import com.fabiantarrach.breakinout.game.component.gdx.Rectangle
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush

interface Hitbox {
	fun render(brush: Brush)
	fun move(velocity: Velocity)
	fun ifOverlaps(other: Hitbox, ifCollision: (Collision) -> Unit)
}

class RectangularHitbox(position: Position, size: Dimension) : Hitbox {

	private val rectangle = Rectangle(position, size)

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
}

class CircularHitbox(position: Position, size: CircleSize) : Hitbox {

	private val circle = Circle(position, size)

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

class NoCollisionAlgorithm(a: Hitbox, b: Hitbox) : RuntimeException("no collision algorithm in ${a::class} for ${b::class}")