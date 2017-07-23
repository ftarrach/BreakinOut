package com.fabiantarrach.breakinout.game.level

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.engine.Engine

// TODO: make a second level and a "LevelManager"
class Level1(private val engine: Engine) {

	fun build() {
		val paddle = Paddle()
		engine.addEntity(paddle)

		val ball = Ball(0f, 0f)
		engine.addEntity(ball)

		(65..85 step 10)
				.map { it / 100f }
				.mapIndexed(this::createLine)
				.flatMap { it }
				.forEach(engine::addEntity)
	}

	private fun createLine(line: Int, y: Float) =
			(-80..80 step 20)
					.map { Brick(it / 100f, y, line + 1) }
}