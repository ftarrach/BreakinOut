package com.fabiantarrach.breakinout.game.component.gdx

import com.badlogic.gdx.math.Intersector
import com.fabiantarrach.breakinout.game.component.euclid.Dimension
import com.fabiantarrach.breakinout.game.component.euclid.Intersection
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.badlogic.gdx.math.Rectangle as GdxRectangle

class Rectangle(position: Position, size: Dimension): Shape {

	private val rectangle: GdxRectangle

	init {
		val xCoordinate = position.xCoordinate()
		val halfWidth = size.halfWidth()
		val x = xCoordinate.floatValue()
		val entityX = x - halfWidth
		val yCoordinate = position.yCoordinate()
		val halfHeight = size.halfHeight()
		val y = yCoordinate.floatValue()
		val entityY = y - halfHeight
		val w = size.width()
		val h = size.height()
		rectangle = GdxRectangle(entityX, entityY, w, h)
	}

	fun intersect(other: Rectangle): Intersection {
		val intersection = GdxRectangle()
		Intersector.intersectRectangles(rectangle, other.rectangle, intersection)
		return intersection.toIntersection()
	}

	override fun render(brush: Brush) {
		brush.drawRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height)
	}

	@Deprecated("getter")
	fun toGdxRectangle(): GdxRectangle = rectangle.clone()

	private fun GdxRectangle.clone() = GdxRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height)

	override fun move(velocity: Velocity) {
		rectangle.x += velocity.xValueAsFloat()
		rectangle.y += velocity.yValueAsFloat()
	}
}