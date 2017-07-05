package com.fabiantarrach.breakinout.game.component.gdx

import com.badlogic.gdx.math.Intersector
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.euclid.collision.Intersection
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.badlogic.gdx.math.Rectangle as GdxRectangle

class Rectangle(x: Float, y: Float, width: Float, height: Float) : Shape {

	private val rectangle = GdxRectangle(x - width / 2, y - height / 2, width, height)

	fun intersect(other: Rectangle): Intersection {
		val intersection = GdxRectangle()
		Intersector.intersectRectangles(rectangle, other.rectangle, intersection)
		return intersection.toIntersection()
	}

	override fun render(brush: Brush) {
		brush.drawRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height)
	}

	@Deprecated("getter")
	fun toGdxRectangle(): GdxRectangle = GdxRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height)

	override fun move(velocity: Velocity) {
		rectangle.x += velocity.xValueAsFloat()
		rectangle.y += velocity.yValueAsFloat()
	}

	@Deprecated("using primitives")
	fun drop(block: (Float, Float) -> Entity): Entity =
			block(rectangle.x + rectangle.width / 2, rectangle.y + rectangle.height / 2)

	fun widen() {
		rectangle.width += 0.05f
		rectangle.x -= 0.025f
	}

	private fun toPosition(): Position {
		val x = rectangle.x + rectangle.width / 2
		val y = rectangle.y + rectangle.height / 2
		return Position(x, y)
	}

	fun differenceTo(mouse: Position): Velocity {
		val myPosition = toPosition()
		return myPosition.moveVelocity(mouse)
	}
}