package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.powerup.PowerUp
import com.fabiantarrach.breakinout.game.meta.Entity
import com.fabiantarrach.breakinout.util.GdxObjectMap
import com.fabiantarrach.breakinout.util.getOrPutIfAbscent
import com.fabiantarrach.breakinout.util.ifEmpty
import ktx.collections.GdxArray
import ktx.collections.gdxArrayOf

class EntityDatabase {

	private val entities = GdxObjectMap<Class<out Entity>, GdxArray<Entity>>()

	fun add(entity: Entity) =
			entities.getOrPutIfAbscent(entity.javaClass, gdxArrayOf())
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

	fun <A : Entity, B : Entity> cross(clazzA: Class<A>, clazzB: Class<B>, block: (A, B) -> Unit) =
			each(clazzA) { a ->
				each(clazzB) { b ->
					block(a, b)
				}
			}

	fun <T : Entity> each(clazz: Class<T>, block: (T) -> Unit) =
			entities.get(clazz, gdxArrayOf())
					.map { clazz.cast(it) }
					.forEach(block)

	fun remove(entity: Entity) {
		entities.get(entity.javaClass)
				.removeValue(entity, true)
	}

	fun ifNoBalls(action: () -> Unit) =
			entities.get(Ball::class.java).ifEmpty {
				action()
			}

	fun clear() = entities.clear()

}