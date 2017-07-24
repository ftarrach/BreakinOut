package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.meta.Entity
import com.fabiantarrach.breakinout.util.GdxArray
import com.fabiantarrach.breakinout.util.GdxObjectMap
import com.fabiantarrach.breakinout.util.getOrPutIfAbscent
import com.fabiantarrach.breakinout.util.ifEmpty
import ktx.collections.gdxArrayOf
import kotlin.reflect.KClass

class EntityMap {
	private val entities = GdxObjectMap<KClass<out Entity>, GdxArray<Entity>>()

	fun put(clazz: KClass<out Entity>, entity: Entity) =
			entities.getOrPutIfAbscent(clazz, gdxArrayOf())
					.add(entity)

	fun forEach(action: (Entity) -> Unit) =
			entities.values()
					.flatMap { it }
					.forEach(action)

	fun <A : Entity, B : Entity> cross(clazzA: KClass<A>, clazzB: KClass<B>, block: (A, B) -> Unit) =
			combine(clazzA, clazzB)
					.forEach {
						block(it.first, it.second)
					}

	private fun <A : Entity, B : Entity> combine(clazzA: KClass<A>, clazzB: KClass<B>) =
			select(clazzA).flatMap { oneItem ->
				select(clazzB).map { otherItem ->
					Pair(oneItem, otherItem) // TODO: this is a 2 level indendation!
				}
			}

	private fun <T : Entity> select(clazz: KClass<T>) =
			entities.get(clazz, gdxArrayOf())
					.map { clazz.java.cast(it) }

	fun <T : Entity> each(clazz: KClass<T>, action: (T) -> Unit) =
			select(clazz)
					.forEach(action)

	fun clear() = entities.clear()

	fun remove(entity: Entity) = removeFromType(entity, entity::class)

	fun removeFromType(entity: Entity, clazz: KClass<out Entity>) {
		entities.get(clazz)
				.removeValue(entity, true)
	}

	fun ifNo(clazz: KClass<out Entity>, action: () -> Unit) =
			entities.get(clazz)
					.ifEmpty(action)

}