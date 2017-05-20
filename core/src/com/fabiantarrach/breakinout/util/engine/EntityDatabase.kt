package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.clone
import ktx.collections.gdxArrayOf

class EntityDatabase {

	private val entities = gdxArrayOf<Entity>()

	fun add(entity: Entity) = entities.add(entity)

	fun selectAll() = SelectedEntities(entities.clone())

	fun selectBalls(): SelectedEntities<Ball> {
		val filteredBalls = entities.filter { it is Ball }
		val balls = filteredBalls.map { it as Ball }
		return SelectedEntities(balls)
	}

	fun selectPaddles(): SelectedEntities<Paddle> {
		val filteredPaddles = entities.filter { it is Paddle }
		val paddles = filteredPaddles.map { it as Paddle }
		return SelectedEntities(paddles)
	}

}