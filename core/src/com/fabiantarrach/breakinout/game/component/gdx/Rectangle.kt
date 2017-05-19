package com.fabiantarrach.breakinout.game.component.gdx

import com.badlogic.gdx.math.Intersector
import com.fabiantarrach.breakinout.game.component.euclid.Dimension
import com.fabiantarrach.breakinout.game.component.euclid.Intersection
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.system.rendering.RenderingToolbox
import com.badlogic.gdx.math.Rectangle as GdxRectangle

class Rectangle(position: Position, size: Dimension): com.fabiantarrach.breakinout.game.entity_v2.component.gdx.Shape {

	private val rectangle: com.badlogic.gdx.math.Rectangle

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
		rectangle = com.badlogic.gdx.math.Rectangle(entityX, entityY, w, h)
	}

	fun intersect(other: Rectangle): Intersection {
		val intersection = com.badlogic.gdx.math.Rectangle()
		Intersector.intersectRectangles(rectangle, other.rectangle, intersection)
		return intersection.toIntersection()
	}

	override fun render(renderer: RenderingToolbox) {
		renderer.drawRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height)
	}

	@Deprecated("getter")
	fun toGdxRectangle(): com.badlogic.gdx.math.Rectangle = rectangle.clone()

	private fun com.badlogic.gdx.math.Rectangle.clone() = com.badlogic.gdx.math.Rectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height)

}