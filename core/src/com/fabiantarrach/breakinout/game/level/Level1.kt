package com.fabiantarrach.breakinout.game.level

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.engine.Engine

// TODO: make a second level and a "LevelManager"
class Level1(private val engine: Engine) {

	fun build() {
		engine.addEntity(Paddle())
//		val ball = Ball(0f, 0f)
//		engine.addEntity(ball)

		val ball2 = Ball(-0.8f, 0f)
		ball2.moveRight()

		engine.addEntity(ball2)
		engine.addEntity(Brick(0f,0f, 5))

		(-80..80 step 20)
				.map { Brick(it / 100f, 0.85f, 3) }
				.forEach { engine.addEntity(it) }
		(-80..80 step 20)
				.map { Brick(it / 100f, 0.75f, 2) }
				.forEach { engine.addEntity(it) }
		(-80..80 step 20)
				.map { Brick(it / 100f, 0.65f, 1) }
				.forEach { engine.addEntity(it) }
	}

}