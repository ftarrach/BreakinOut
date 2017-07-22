package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.entity.powerup.PowerUp
import com.fabiantarrach.breakinout.game.meta.Entity
import com.fabiantarrach.breakinout.util.GdxObjectMap
import com.fabiantarrach.breakinout.util.getOrPutIfAbscent
import com.fabiantarrach.breakinout.util.ifEmpty
import ktx.collections.GdxArray
import ktx.collections.gdxArrayOf
import kotlin.reflect.KClass

class EntityDatabase {

	// TODO: try to move this into an own class. Maybe inject in via the constructor
	// to gain a game specific Map, e.x. for BreakOut: save all PowerUps under a
	// common PowerUp key
	private val entities = GdxObjectMap<KClass<out Entity>, GdxArray<Entity>>()

	fun add(entity: Entity) {
		if (entity is PowerUp)
			return entities.getOrPutIfAbscent(PowerUp::class, gdxArrayOf())
					.add(entity)

		entities.getOrPutIfAbscent(entity::class, gdxArrayOf())
				.add(entity)
	}

	fun eachEntity(action: (Entity) -> Unit) =
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

	fun <T : Entity> each(clazz: KClass<T>, block: (T) -> Unit) =
			select(clazz)
					.forEach(block)

	private fun <T : Entity> select(clazz: KClass<T>) =
			entities.get(clazz, gdxArrayOf())
					.map { clazz.java.cast(it) }

	fun remove(entity: Entity) {
		if (entity is PowerUp) {
			entities.get(PowerUp::class)
					.removeValue(entity, true)
			return
		}
		entities.get(entity::class)
				.removeValue(entity, true)
	}

	fun <T : Entity> ifNo(clazz: KClass<T>, action: () -> Unit) =
			entities.get(clazz)
					.ifEmpty(action)

	fun clear() = entities.clear()

}