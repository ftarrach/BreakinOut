package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.circle.Circle
import com.fabiantarrach.breakinout.game.meta.MovingEntity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.math.Y

class Ball(x: Float, y: Float) : MovingEntity(Velocity(0f, -1f)) {

	override val shape = Circle(x, y, 0.025f)

	override fun update(delta: Timespan) {
		super.update(delta)
		shape.ifOutsideGame(
				left = this::bounceOffSide,
				right = this::bounceOffSide,
				top = this::bounceOffFront,
				bottom = this::die)
	}

	override public fun moveRandom() = super.moveRandom()

	override fun render(renderer: GdxShapeRenderer) = shape.render(renderer, GdxColor.RED)

	fun ifOverlaps(paddle: Paddle, then: () -> Unit) = super.ifOverlaps(paddle, then)
	fun ifOverlaps(brick: Brick, then: () -> Unit) = super.ifOverlaps(brick, then)

	override public fun bounceOffFront() = super.bounceOffFront()

	override public fun bounceOffSide() = super.bounceOffSide()

	fun bounceOffFront(paddle: Paddle) {
		bounceOffFront()
		paddle.scrub(this)
		val relative = positionRelativeTo(paddle)
		var pushVelocity = Velocity(relative, Y(0f))
		ifMovingRight {
			pushVelocity = pushVelocity.invert()
		}
		push(pushVelocity)
	}

	fun ifNextTo(brick: Brick, then: () -> Unit, ifNot: () -> Unit = {}) =
			super.ifNextTo(brick, then, ifNot)

	fun ifUnderFront(paddle: Paddle, then: () -> Unit, ifFront: () -> Unit) =
			super.ifNextTo(paddle, then,
					ifNot = {
						super.ifUnder(paddle, then, ifFront)
					})

	override public fun slamX(other: Velocity) = super.slamX(other)

}