package com.fabiantarrach.breakinout.game.component.gdx


import com.badlogic.gdx.math.Intersector
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.euclid.PositionDifference
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxVector

class Rectangle(x: Float, y: Float, width: Float, height: Float) : Shape {

	private val rectangle = GdxRectangle(x - width / 2, y - height / 2, width, height)

	override fun render(brush: Brush, color: GdxColor) = brush.drawRectangle(rectangle, color)
	override fun move(velocity: Velocity) = velocity.addOn(rectangle)

	fun drop(block: (Float, Float) -> Entity): Entity {
		val center = center()
		return block(center.x, center.y)
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
			val sideCollision =
					(rectangle.y..rectangle.y + rectangle.height)
							.contains(other.y)
			val difference = PositionDifference(deltaX, sideCollision)
			action(difference)
		}
	}

	private fun relativeX(x: Float): Float = -(center().x - x) / (rectangle.width / 2)

	private fun ifOverlapsRectangle(other: Rectangle, action: (PositionDifference) -> Unit) {
		val otherRectangle = other.rectangle
		if (Intersector.overlaps(rectangle, otherRectangle)) {
			val deltaX = relativeX(otherRectangle.x)
			val sideCollision =
					(rectangle.y..rectangle.y + rectangle.height)
							.contains(
									other.center().y)
			val difference = PositionDifference(deltaX, sideCollision)
			action(difference)
		}
	}

	fun calculateVelocityTo(mouse: Position): Velocity {
		val center = center()
		return Position(center.x, center.y)
				.createMoveVelocity(mouse)
	}

	private fun center() = rectangle.getCenter()

	override fun ifOutsideGame(left: () -> Unit, right: () -> Unit, top: () -> Unit, bottom: () -> Unit) {
		if (rectangle.x < -1) left()
		if (rectangle.x + rectangle.width > 1) right()
		if (rectangle.y + rectangle.height > 1) top()
		if (rectangle.y < -1) bottom()
	}

	private fun GdxRectangle.getCenter() = getCenter(GdxVector())

}