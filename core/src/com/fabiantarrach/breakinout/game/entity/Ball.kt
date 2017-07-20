package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.circle.Circle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.MovingEntity
import com.fabiantarrach.breakinout.util.engine.Timespan
import com.fabiantarrach.breakinout.util.math.Y

class Ball(x: Float, y: Float) : MovingEntity(Velocity(0f, -1f)) {

	override val shape = Circle(x, y, 0.025f)
	// TODO: 3 members. MoveableEntity class?
	private var lastTimespan: Timespan = Timespan(0f)

	override fun update(delta: Timespan) {
		lastTimespan = delta
		shape.move(velocity * delta)
		shape.ifOutsideGame(
				left = this::bounceOffSide,
				right = this::bounceOffSide,
				top = this::bounceOffFront,
				bottom = this::die)
	}

	override public fun moveRandom() = super.moveRandom()

	override fun render(renderer: GdxShapeRenderer) = shape.render(renderer, GdxColor.RED)

	fun ifOverlaps(paddle: Paddle, then: () -> Unit) = super.ifOverlaps(paddle, then)
	fun ifOverlaps(paddle: Brick, then: () -> Unit) = super.ifOverlaps(paddle, then)

	fun ifMovingDown(then: () -> Unit) = velocity.ifMovingDown(then)

	override public fun bounceOffSide() = super.bounceOffSide()

	fun bounceOffFront() {
		velocity = velocity.deflectFront()
	}

	fun bounceOffFront(paddle: Paddle) {
		bounceOffFront()
		paddle.scrub(this)
		val relativeTo = positionRelativeTo(paddle)
		var pushVelocity = Velocity(relativeTo.double(), Y(0f))
		velocity.ifMovingRight {
			pushVelocity = pushVelocity.invert()
		}
		velocity = velocity.push(pushVelocity)
	}

	fun ifNextTo(brick: Brick, then: () -> Unit, ifNot: () -> Unit = {}) =
			super.ifNextTo(brick, then, ifNot)

	fun ifUnderFront(paddle: Paddle, then: () -> Unit, ifFront: () -> Unit) =
			super.ifNextTo(paddle, then) {
				super.ifUnder(paddle, then, ifFront)
			}

	fun revertLastMove() {
		shape.move(velocity.invert() * lastTimespan)
	}

	fun slamX(other: Velocity) {
		shape.move(other * lastTimespan)
		velocity += other
	}
}