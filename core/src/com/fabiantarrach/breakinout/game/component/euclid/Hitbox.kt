package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.game.component.gdx.Circle
import com.fabiantarrach.breakinout.game.component.gdx.Rectangle
import com.fabiantarrach.breakinout.game.component.gdx.Shape
import com.fabiantarrach.breakinout.game.system.rendering.RenderingToolbox

interface Hitbox {
	fun render(tools: RenderingToolbox)
}

abstract class BaseHitbox(protected val area: Shape) : Hitbox

class RectangularHitbox(position: Position, size: Dimension) : Hitbox {

	private val rectangle = Rectangle(position, size)

//  TODO: remove comments if this function is needed
//	fun overlapsCircle(other: CircularHitbox, ifCollision: (Collision) -> Unit) {
//		other.overlapsRectangle(this, ifCollision)
//	}

	@Deprecated("Getter?")
	fun toShape() = rectangle

	override fun render(tools: RenderingToolbox) = rectangle.render(tools)

}

class CircularHitbox(position: Position, size: CircleSize) : Hitbox {

	private val circle = Circle(position, size)

	fun overlapsRectangle(other: RectangularHitbox, ifCollision: (Collision) -> Unit) {
		val otherShape = other.toShape()
		val intersection = circle.intersect(otherShape)
		val collision = intersection.createCollision()
		collision.acceptIfCollision { ifCollision(collision) }
	}

	override fun render(tools: RenderingToolbox) {
		circle.render(tools)
	}
}
