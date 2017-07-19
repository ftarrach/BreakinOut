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

	override fun update(delta: Timespan) {
		shape.move(velocity * delta)
		shape.ifOutsideGame(
				left = this::bounceOffSide,
				right = this::bounceOffSide,
				top = this::bounceOffFront,
				bottom = this::die)
	}

	override fun render(renderer: GdxShapeRenderer) = shape.render(renderer, GdxColor.RED)

	fun ifMovingDown(then: () -> Unit) = velocity.ifMovingDown(then)

	fun bounceOffFront() {
		// TODO: pass metadata of the collision etc
		velocity = velocity.deflectFront()
		println("new velocity: $velocity")
	}

	fun bounceOffSide() {
		velocity = velocity.deflectSide()
		println("new velocity: $velocity")
	}

	fun moveRandom() {
		velocity = velocity.randomizeAngle()
	}

	fun push(push: Velocity) {
		velocity = velocity.push(push)
	}

}