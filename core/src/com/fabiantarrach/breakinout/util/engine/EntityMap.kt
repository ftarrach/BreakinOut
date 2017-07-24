package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.util.GdxArray
import com.fabiantarrach.breakinout.util.GdxObjectMap
import com.fabiantarrach.breakinout.util.getOrPutIfAbscent
import com.fabiantarrach.breakinout.util.ifTrue
import ktx.collections.gdxArrayOf
import ktx.collections.isEmpty
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

	fun <A : Entity, B : Entity> cross(clazzA: KClass<A>, clazzB: KClass<B>, action: (A, B) -> Unit) {
		combine(clazzA, clazzB, action)
	}

	private fun <A : Entity, B : Entity> combine(clazzA: KClass<A>, clazzB: KClass<B>, action: (A, B) -> Unit) =
			select(clazzA).flatMap { oneItem ->
				combineB(clazzB, oneItem, action)
			}

	private fun <A : Entity, B : Entity> combineB(clazzB: KClass<B>, oneItem: A, block: (A, B) -> Unit) =
			select(clazzB).map { otherItem ->
				block(oneItem, otherItem)
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
					.isEmpty()
					.ifTrue(action)

}