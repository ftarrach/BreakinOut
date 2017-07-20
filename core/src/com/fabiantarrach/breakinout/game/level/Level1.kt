package com.fabiantarrach.breakinout.game.level

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.util.engine.Engine

// TODO: make a second level and a "LevelManager"
class Level1(private val engine: Engine) {

	fun build() {
//		engine.addEntity(Paddle())

//		engine.addEntity(Brick(0f,0f, 99))

//		val brickLeft = Ball(-0.8f, 0f)
//		brickLeft.moveRight()
//		engine.addEntity(brickLeft)
//
//		val brickRight = Ball(0.8f, 0f)
//		brickRight.moveRight()
//		engine.addEntity(brickRight)
//
//		val brickTopCenter = Ball(0f, 0.8f)
//		engine.addEntity(brickTopCenter)
//
//		val brickTopLeftEdge = Ball(-0.1f, 0.8f)
//		engine.addEntity(brickTopLeftEdge)
//
//		val brickTopRightEdge = Ball(0.1f, 0.8f)
//		engine.addEntity(brickTopRightEdge)

		val paddleLeft = Ball(-0.8f, -0.8f)
		paddleLeft.moveRight()
		engine.addEntity(paddleLeft)

//		val paddleBrick = Ball(0f, -0.5f)
//		engine.addEntity(paddleBrick)
//
//		val paddleLeftUnder = Ball(-0.9f, -0.826f)
//		paddleLeftUnder.moveRight()
//		engine.addEntity(paddleLeftUnder)
//
//		val paddleLeftUnder2 = Ball(-0.9f, -0.85f)
//		paddleLeftUnder2.moveRight()
//		engine.addEntity(paddleLeftUnder2)

	}

}