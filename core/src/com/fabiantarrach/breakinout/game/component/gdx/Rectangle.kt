package com.fabiantarrach.breakinout.game.component.gdx

import com.badlogic.gdx.math.Intersector
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.GdxCircle
import com.badlogic.gdx.math.Rectangle as GdxRectangle

class Rectangle(x: Float, y: Float, width: Float, height: Float) : Shape {

	private val rectangle = GdxRectangle(x - width / 2, y - height / 2, width, height)

	override fun render(brush: Brush) {
		brush.drawRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height)
	}

	override fun move(velocity: Velocity) {
		velocity.move(rectangle)
	}

	@Deprecated("using primitives")
	fun drop(block: (Float, Float) -> Entity): Entity =
			block(rectangle.x + rectangle.width / 2, rectangle.y + rectangle.height / 2)

	fun widen() {
		rectangle.width += 0.05f
		rectangle.x -= 0.025f
	}

	override fun ifOverlaps(other: Shape, action: () -> Unit) {
		if (other is Rectangle) {
			ifOverlapsRectangle(other, action)
			return
		}
		if (other is Circle) {
			ifOverlapsCircle(other, action)
			return
		}
		throw NoCollisionAlgorithmFound(this, other)
	}

	private fun ifOverlapsCircle(other: Circle, action: () -> Unit) {
		other.giveCircle {
			ifOverlapsGdxCircle(it, action)
		}
	}

	private fun ifOverlapsGdxCircle(it: GdxCircle, action: () -> Unit) {
		if (Intersector.overlaps(it, rectangle)) {
			action()
		}
	}

	private fun ifOverlapsRectangle(other: Rectangle, action: () -> Unit) {
		if (Intersector.overlaps(rectangle, other.rectangle)) {
			action()
		}
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