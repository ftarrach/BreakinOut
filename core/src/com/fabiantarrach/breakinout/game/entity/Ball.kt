package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.circle.Circle
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.Timespan

class Ball(x: Float, y: Float) : Entity() {

	override val shape = Circle(x, y, 0.025f)
	private var velocity = Velocity(0f, -1f)
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

	override fun render(renderer: GdxShapeRenderer) = shape.render(renderer, GdxColor.RED)

	fun ifOverlaps(paddle: Paddle, then: () -> Unit) = super.ifOverlaps(paddle, then)
	fun ifOverlaps(paddle: Brick, then: () -> Unit) = super.ifOverlaps(paddle, then)

	fun ifMovingDown(then: () -> Unit) = velocity.ifMovingDown(then)

	fun bounceOffFront() {
		// TODO: pass metadata of the collision etc
		velocity = velocity.deflectFront()
	}

	fun bounceOffSide() {
		velocity = velocity.deflectSide()
	}

	fun moveRandom() {
		velocity = velocity.randomizeAngle()
	}

	fun push(push: Velocity) {
		velocity = velocity.push(push)
	}

	@Deprecated("debug only")
	fun moveRight() {
		velocity = Velocity(1f, -Float.MIN_VALUE)
	}

	fun ifNextTo(brick: Brick, then: () -> Unit, ifNot: () -> Unit = {}) =
			super.ifNextTo(brick, then, ifNot)

	fun ifUnderFront(paddle: Paddle, then: () -> Unit, ifFront: () -> Unit) =
			super.ifNextTo(paddle, then) {
				super.ifUnder(paddle, then, ifFront)
			}

	fun slamX(other: Velocity) {
		shape.move(other * lastTimespan)
		velocity += other
	}
}