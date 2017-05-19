package com.fabiantarrach.breakinout.game.component.euclid

import com.fabiantarrach.breakinout.game.entity_v2.component.gdx.Circle
import com.fabiantarrach.breakinout.game.entity_v2.component.gdx.Rectangle
import com.fabiantarrach.breakinout.game.entity_v2.component.gdx.Shape
import com.fabiantarrach.breakinout.game.system.rendering.RenderingToolbox

interface Hitbox {
	fun render(tools: RenderingToolbox)
}

abstract class BaseHitbox(protected val area: com.fabiantarrach.breakinout.game.entity_v2.component.gdx.Shape) : Hitbox

class RectangularHitbox(position: com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Position, size: com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Dimension) : Hitbox {

	private val rectangle = com.fabiantarrach.breakinout.game.entity_v2.component.gdx.Rectangle(position, size)

//  TODO: remove comments if this function is needed
//	fun overlapsCircle(other: CircularHitbox, ifCollision: (Collision) -> Unit) {
//		other.overlapsRectangle(this, ifCollision)
//	}

	@Deprecated("Getter?")
	fun toShape() = rectangle

	override fun render(tools: RenderingToolbox) = rectangle.render(tools)

}

class CircularHitbox(position: com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Position, size: com.fabiantarrach.breakinout.game.entity_v2.component.euclid.CircleSize) : Hitbox {

	private val circle = com.fabiantarrach.breakinout.game.entity_v2.component.gdx.Circle(position, size)

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
