package com.fabiantarrach.breakinout.game.component

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Intersector
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Shape2D
import com.fabiantarrach.breakinout.game.renderer.Renderer

sealed class Hitbox<out T : Shape2D> {

	abstract fun hitbox(): T
	abstract fun update(area: Area)

	abstract fun render(renderer: Renderer)
	abstract fun overlaps(other: Hitbox<*>): Boolean

	class RectangularHitbox : Hitbox<Rectangle>() {

		private val hitbox = Rectangle()

		override fun hitbox() = hitbox

		override fun update(area: Area) {
			hitbox.set(area.xLeft(), area.yBottom(), area.width(), area.height())
		}

		override fun render(renderer: Renderer) = renderer.drawBox(hitbox, Color.WHITE)

		override fun overlaps(other: Hitbox<*>) = when (other) {
			is RectangularHitbox -> overlapsRectangle(other)
			is CircularHitbox -> overlapsCircle(other)
		}

		fun overlapsRectangle(other: RectangularHitbox) = rectangleOverlapsRectangle(hitbox, other.hitbox)
		fun overlapsCircle(other: CircularHitbox) = circleOverlapsRectangle(other.hitbox(), hitbox)
	}

	class CircularHitbox : Hitbox<Circle>() {
		private val hitbox = Circle()

		override fun hitbox() = hitbox

		override fun update(area: Area) =
				hitbox.set(area.xCenter(), area.yCenter(), area.halfWidth())

		override fun render(renderer: Renderer) {
			renderer.drawCircle(hitbox, Color.RED)
			renderer.drawLine(hitbox.x - 1, hitbox.y, hitbox.x + 1, hitbox.y)
			renderer.drawLine(hitbox.x, hitbox.y - 1, hitbox.x, hitbox.y + 1)
		}

		override fun overlaps(other: Hitbox<*>) = when (other) {
			is RectangularHitbox -> overlapsRectangle(other)
			is CircularHitbox -> overlapsCircle(other)
		}

		fun overlapsRectangle(other: RectangularHitbox) = circleOverlapsRectangle(hitbox, other.hitbox())
		fun overlapsCircle(other: CircularHitbox) = circleOverlapsCircle(hitbox, other.hitbox)
	}

}

private fun circleOverlapsRectangle(circle: Circle, rectangle: Rectangle) =
		Intersector.overlaps(circle, rectangle)

private fun circleOverlapsCircle(circle1: Circle, circle2: Circle) =
		circle1.overlaps(circle2)

private fun rectangleOverlapsRectangle(rectangle1: Rectangle, rectangle2: Rectangle) =
		rectangle1.overlaps(rectangle2)
