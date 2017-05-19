package com.fabiantarrach.breakinout.game.component.gdx

import com.badlogic.gdx.math.Intersector
import com.fabiantarrach.breakinout.game.component.euclid.CircleSize
import com.fabiantarrach.breakinout.game.component.euclid.Intersection
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.badlogic.gdx.math.Circle as GdxCircle
import com.badlogic.gdx.math.Rectangle as GdxRectangle

class Circle(position: Position, size: CircleSize) : com.fabiantarrach.breakinout.game.component.gdx.Shape {
	private val circle: com.badlogic.gdx.math.Circle

	init {
		val xCoordinate = position.xCoordinate()
		val x = xCoordinate.floatValue()
		val yCoordinate = position.yCoordinate()
		val y = yCoordinate.floatValue()
		val radius = size.radius()
		circle = GdxCircle(x, y, radius)
	}

	fun intersect(other: Rectangle): Intersection {
		val intersection = GdxRectangle()
		val otherBox = other.toGdxRectangle()
		val box = boundingBox()
		Intersector.intersectRectangles(box, otherBox, intersection)
		// TODO: this isn't an optimal implementation, if a circle collides with the rectangle on an edge one of the dimensions will be off.
		// TODO: actually, if the collision is really sharp, it will be a lot off.
		// TODO: make it better
		// http://stackoverflow.com/questions/622287/area-of-intersection-between-circle-and-rectangle
		return intersection.toIntersection()
	}

	private fun boundingBox() : GdxRectangle {
		val diameter = circle.radius * 2
		val leftEdge = circle.x - circle.radius
		val bottomEdge = circle.y - circle.radius
		return GdxRectangle(leftEdge, bottomEdge, diameter, diameter)
	}

	fun intersect(other: Circle): Intersection {
		val intersection = GdxRectangle()
		val otherBox = other.boundingBox()
		val box = boundingBox()
		Intersector.intersectRectangles(box, otherBox, intersection)
		return intersection.toIntersection()
	}

	override fun render(brush: Brush) {
		brush.drawCircle(circle.x, circle.y, circle.radius)
	}

}