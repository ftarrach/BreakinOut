package com.fabiantarrach.breakinout.game

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.game.system.*
import com.fabiantarrach.breakinout.game.system.rendering.RenderingSystem
import com.fabiantarrach.breakinout.util.engine.Engine
import com.fabiantarrach.breakinout.util.screen.Camera

class BreakinOutEngine(private val camera: Camera) : Engine() {

	override fun buildGame() {
		createEntities()
		createSystems()
	}

	private fun createSystems() {
		addSystem(PlayerInput(camera))
		addSystem(EntityUpdate())
		addSystem(BallPaddleCollision())
		addSystem(BallBrickCollision())
		addSystem(PaddlePowerUpCollision())
		addSystem(RemoveDead())
		addSystem(RenderingSystem(camera))
	}

	private fun createEntities() {
		createBall(0f, 0f)
		createPaddle()
		(-80..80 step 20).forEach {
			val x = it.toFloat() / 100
			createBrick(x, 0.85f)
			createBrick(x, 0.65f)
		}
		(-70..70 step 20).forEach {
			val x = it.toFloat() / 100
			createBrick(x, 0.75f)
		}
	}

	private fun createPaddle() {
		val paddle = Paddle(0f, -0.8f)
		addEntity(paddle)
	}

	private fun createBall(x: Float, y: Float) {
		val ball = Ball(x, y)
		addEntity(ball)
	}

	private fun createBrick(x: Float, y: Float) {
		val brick = Brick(x, y)
		addEntity(brick)
	}

}