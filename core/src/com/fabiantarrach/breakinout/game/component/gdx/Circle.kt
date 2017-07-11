package com.fabiantarrach.breakinout.game.component.gdx

import com.badlogic.gdx.math.Intersector
import com.fabiantarrach.breakinout.game.component.euclid.NoPositionDifference
import com.fabiantarrach.breakinout.game.component.euclid.PositionDifference
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxColor

class Circle(x: Float, y: Float, radius: Float) : Shape {

	private val circle = GdxCircle(x, y, radius)

	override fun render(brush: Brush, color: GdxColor) =
			brush.drawCircle(circle, color)

	override fun ifOverlaps(other: Shape, action: (PositionDifference) -> Unit) {
		if (other is Circle) {
			ifOverlapsCircle(other, action)
			return
		}
		if (other is Rectangle) {
			other.ifOverlaps(this, action)
			return
		}
		throw NoCollisionAlgorithm(this, other)
	}

	private fun ifOverlapsCircle(other: Circle, action: (PositionDifference) -> Unit) {
		if (Intersector.overlaps(circle, other.circle))
			action(NoPositionDifference) // TODO: calculate difference
	}

	fun giveCircle(block: (GdxCircle) -> Unit) =
			block(circle)

	override fun move(velocity: Velocity) =
			velocity.move(circle)

	override fun ifOutsideGame(left: () -> Unit, right: () -> Unit, top: () -> Unit, bottom: () -> Unit) {
		if (circle.x - circle.radius < -1) left()
		if (circle.x + circle.radius > 1) right()
		if (circle.y + circle.radius > 1) top()
		if (circle.y + circle.radius < -1) bottom()
	}

	fun keepInsideGame() {
		if (circle.x - circle.radius < -1) circle.x = -1 + circle.radius
		if (circle.x + circle.radius > 1) circle.x = 1 - circle.radius
		if (circle.y + circle.radius > 1) circle.y = 1 - circle.radius
		if (circle.y + circle.radius < -1) circle.y = -1 + circle.radius
	}

}