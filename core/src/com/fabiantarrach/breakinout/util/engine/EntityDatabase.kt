package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.game.entity.goodie.Goodie
import kotlin.reflect.KClass

class EntityDatabase {

	private val entities = EntityStorage()

	fun add(entity: Entity) {
		if (entity is Goodie)
			return entities.put(Goodie::class, entity)
		if (entity is Brick)
			return entities.put(Brick::class, entity)
		entities.put(entity::class, entity)
	}

	fun eachEntity(action: (Entity) -> Unit) =
			entities.forEach(action)

	fun <A : Entity, B : Entity> cross(clazzA: KClass<A>, clazzB: KClass<B>, block: (A, B) -> Unit) {
		entities.cross(clazzA, clazzB, block)
	}

	fun <T : Entity> each(clazz: KClass<T>, action: (T) -> Unit) =
			entities.each(clazz, action)

	fun remove(entity: Entity) {
		if (entity is Goodie)
			return entities.removeFromType(entity, Goodie::class)
		if (entity is Brick)
			return entities.removeFromType(entity, Brick::class)
		entities.remove(entity)
	}

	fun ifNo(clazz: KClass<out Entity>, action: () -> Unit) =
			entities.ifNo(clazz, action)

	fun clear() =
			entities.clear()

}