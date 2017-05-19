package com.fabiantarrach.breakinout.util

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Entity
import com.fabiantarrach.breakinout.game.entity.MoveableEntity
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.badlogic.gdx.utils.Array as GdxArray

class EntityManager {

	private val entities = EntityList<Entity>()

	fun all(): Iterable<Entity> = entities
	fun moveableEntities(): Iterable<MoveableEntity> = entities.filter { it is MoveableEntity }.map { it as MoveableEntity }
	fun paddles(): Iterable<Paddle> = entities.filter { it is Paddle }.map { it as Paddle }
	fun balls(): Iterable<Ball> = entities.filter { it is Ball }.map{ it as Ball }

	fun addEntity(entity: Entity) = entities.add(entity)
	fun clear() = entities.clear()

	class EntityList<T : Entity> : Iterable<T> {

		private val list = com.badlogic.gdx.utils.Array<T>()

		fun add(element: T) = list.add(element)

		fun clear() = list.clear()

		override fun iterator(): Iterator<T> = list.iterator()

		override fun toString(): String = list.toString()
	}
}