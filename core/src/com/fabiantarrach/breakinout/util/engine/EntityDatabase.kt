package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.entity.powerup.PowerUp
import com.fabiantarrach.breakinout.game.meta.Entity
import com.fabiantarrach.breakinout.util.GdxObjectMap
import com.fabiantarrach.breakinout.util.getOrPutIfAbscent
import com.fabiantarrach.breakinout.util.ifEmpty
import ktx.collections.GdxArray
import ktx.collections.gdxArrayOf
import kotlin.reflect.KClass

// TODO: use an "Role-Enum" instead of classes. Saves a lot of lines and solves the Inheritance Problem
class EntityDatabase {

	private val entities = GdxObjectMap<KClass<out Entity>, GdxArray<Entity>>()

	fun add(entity: Entity) =
			entities.getOrPutIfAbscent(entity::class, gdxArrayOf())
					.add(entity)

	fun eachEntity(action: (Entity) -> Unit) =
			entities.values()
					.flatMap { it }
					.forEach(action)

	fun eachPowerUp(action: (PowerUp) -> Unit) =
			entities.values()
					.flatMap { it }
					.map { it as? PowerUp }
					.filterNotNull()
					.forEach(action)

	fun <A : Entity, B : Entity> cross(clazzA: KClass<A>, clazzB: KClass<B>, block: (A, B) -> Unit) =
			combine(clazzA, clazzB)
					.forEach {
						block(it.first, it.second)
					}

	private fun <A : Entity, B : Entity> combine(clazzA: KClass<A>, clazzB: KClass<B>): List<Pair<A, B>> =
			select(clazzA).flatMap { oneItem ->
				select(clazzB).map { otherItem ->
					Pair(oneItem, otherItem) // TODO: 2 level indendation!
				}
			}

	fun <T : Entity> each(clazz: KClass<T>, block: (T) -> Unit) =
			select(clazz)
					.forEach(block)

	private fun <T : Entity> select(clazz: KClass<T>) =
			entities.get(clazz, gdxArrayOf())
					.map { clazz.java.cast(it) }

	fun remove(entity: Entity) {
		entities.get(entity::class)
				.removeValue(entity, true)
	}

	fun <T : Entity> ifNo(clazz: KClass<T>, action: () -> Unit) =
			entities.get(clazz)
					.ifEmpty(action)

	fun clear() = entities.clear()

}