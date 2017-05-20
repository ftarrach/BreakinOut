package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.game.component.gdx.Circle
import com.fabiantarrach.breakinout.game.component.gdx.Rectangle
import com.fabiantarrach.breakinout.game.component.gdx.Shape
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush

interface Hitbox {
	fun render(brush: Brush)
	fun move(velocity: Velocity)
}

abstract class BaseHitbox(protected val area: Shape) : Hitbox

class RectangularHitbox(position: Position, size: Dimension) : Hitbox {

	private val rectangle = Rectangle(position, size)

//  TODO: remove comment if this function is needed
//	fun overlapsCircle(other: CircularHitbox, ifCollision: (Collision) -> Unit) {
//		other.overlapsRectangle(this, ifCollision)
//	}

	@Deprecated("Getter?")
	fun toShape() = rectangle

	override fun render(brush: Brush) = rectangle.render(brush)

	override fun move(velocity: Velocity) = rectangle.move(velocity)

}

class CircularHitbox(position: Position, size: CircleSize) : Hitbox {

	private val circle = Circle(position, size)

	fun overlapsRectangle(other: RectangularHitbox, ifCollision: (Collision) -> Unit) {
		val otherShape = other.toShape()
		val intersection = circle.intersect(otherShape)
		val collision = intersection.createCollision()
		collision.acceptIfCollision { ifCollision(collision) }
	}

	override fun render(brush: Brush) {
		circle.render(brush)
	}

	override fun move(velocity: Velocity) {
		circle.move(velocity)
	}
}
