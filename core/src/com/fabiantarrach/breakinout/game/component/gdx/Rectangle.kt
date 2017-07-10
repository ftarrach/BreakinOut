package com.fabiantarrach.breakinout.game.component.gdx

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Intersector
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.euclid.PositionDifference
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxRectangle

class Rectangle(x: Float, y: Float, width: Float, height: Float) : Shape {

	private val rectangle = GdxRectangle(x - width / 2, y - height / 2, width, height)

	private fun centeredX() = rectangle.x + rectangle.width / 2

	override fun render(brush: Brush, color: Color) =
			brush.drawRectangle(rectangle, color)

	override fun move(velocity: Velocity) =
			velocity.move(rectangle)

	fun drop(block: (Float, Float) -> Entity): Entity {
		val centeredX = centeredX()
		return block(centeredX, rectangle.y + rectangle.height / 2)
	}

	fun shorten() {
		rectangle.width -= 0.05f
		rectangle.x += 0.025f
	}

	fun widen() {
		rectangle.width += 0.05f
		rectangle.x -= 0.025f
	}

	override fun ifOverlaps(other: Shape, action: (PositionDifference) -> Unit) {
		if (other is Rectangle) {
			ifOverlapsRectangle(other, action)
			return
		}
		if (other is Circle) {
			ifOverlapsCircle(other, action)
			return
		}
		throw NoCollisionAlgorithm(this, other)
	}

	private fun ifOverlapsCircle(other: Circle, action: (PositionDifference) -> Unit) =
			other.giveCircle {
				ifOverlapsGdxCircle(it, action)
			}

	private fun ifOverlapsGdxCircle(other: GdxCircle, action: (PositionDifference) -> Unit) {
		if (Intersector.overlaps(other, rectangle)) {
			val deltaX = relativeX(other.x)
			val deltaY = rectangle.y - other.y
			val difference = PositionDifference(deltaX, deltaY)
			action(difference)
		}
	}

	private fun relativeX(x: Float): Float {
		return -(centeredX() - x) / (rectangle.width / 2)
	}

	private fun ifOverlapsRectangle(other: Rectangle, action: (PositionDifference) -> Unit) {
		val otherRectangle = other.rectangle
		if (Intersector.overlaps(rectangle, otherRectangle)) {
			val deltaX = relativeX(otherRectangle.x)
			val deltaY = rectangle.y - otherRectangle.y
			val difference = PositionDifference(deltaX, deltaY)
			action(difference)
		}
	}

	fun calculateVelocityTo(mouse: Position): Velocity {
		val x = centeredX()
		val y = rectangle.y + rectangle.height / 2
		val position = Position(x, y)
		val velocity = position.moveVelocity(mouse)
		return velocity
	}

	override fun ifOutsideGame(left: () -> Unit, right: () -> Unit, top: () -> Unit, bottom: () -> Unit) {
		if (rectangle.x < -1) left()
		if (rectangle.x + rectangle.width > 1) right()
		if (rectangle.y + rectangle.height > 1) top()
		if (rectangle.y < -1) bottom()
	}

}