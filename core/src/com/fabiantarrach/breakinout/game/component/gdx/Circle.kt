package com.fabiantarrach.breakinout.game.component.gdx

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Intersector
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.GdxCircle

class Circle(x: Float, y: Float, radius: Float) : Shape {

	private val circle = GdxCircle(x, y, radius)

	override fun render(brush: Brush, color: Color) =
			brush.drawCircle(circle, color)

	override fun ifOverlaps(other: Shape, action: () -> Unit) {
		if (other is Circle) {
			ifOverlapsCircle(other, action)
			return
		}
		if (other is Rectangle) {
			other.ifOverlaps(this, action)
			return
		}
		throw NoCollisionAlgorithmFound(this, other)
	}

	private fun ifOverlapsCircle(other: Circle, action: () -> Unit) {
		if (Intersector.overlaps(circle, other.circle))
			action()
	}

	fun giveCircle(block: (GdxCircle) -> Unit) =
			block(circle)

	override fun move(velocity: Velocity) =
			velocity.move(circle)

	fun ifOutsideGame(left: () -> Unit, right: () -> Unit, top: () -> Unit, bottom: () -> Unit) {
		val outerLeft = circle.x - circle.radius
		val outerRight = circle.x + circle.radius
		val outerTop = circle.y + circle.radius
		val outerBottom = circle.y + circle.radius
		if (outerLeft < -1)
			left()
		if (outerRight > 1)
			right()
		if (outerTop > 1)
			top()
		if (outerBottom < -1)
			bottom()
	}
}