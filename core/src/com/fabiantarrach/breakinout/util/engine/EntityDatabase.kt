package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.game.entity.Paddle
import ktx.collections.gdxArrayOf

class EntityDatabase {

	private val entities = gdxArrayOf<Entity>()

	fun add(entity: Entity) {
		entities.add(entity)
	}

	fun eachEntity(action: (Entity) -> Unit) = entities.forEach(action)

	fun eachBall(action: (Ball) -> Unit) {
		entities.filter { it is Ball }
				.map { it as Ball }
				.forEach(action)
	}

	fun eachPaddle(action: (Paddle) -> Unit) {
		entities.filter { it is Paddle }
				.map { it as Paddle }
				.forEach(action)
	}

	fun eachBrick(action: (Brick) -> Unit) {
		entities.filter { it is Brick }
				.map { it as Brick }
				.forEach(action)
	}

	fun remove(entity: Entity) {
		entities.removeValue(entity, true)
	}

}