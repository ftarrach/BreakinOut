package com.fabiantarrach.breakinout.game.level

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.engine.Engine

// TODO: make a second level and a "LevelManager"
class Level1(private val engine: Engine) {

	fun build() {
		engine.addEntity(Paddle())

		engine.addEntity(Brick(0f,0f, 99))

		val ball2 = Ball(-0.8f, 0f)
		ball2.moveRight()
		engine.addEntity(ball2)
		
		val ball3 = Ball(-0.8f, -0.8f)
		ball3.moveRight()
		engine.addEntity(ball3)

		val ball4 = Ball(0f, -0.5f)
		engine.addEntity(ball4)

		val ball5 = Ball(-0.9f, -0.8f)
		ball5.moveRight()
		engine.addEntity(ball5)


	}

}