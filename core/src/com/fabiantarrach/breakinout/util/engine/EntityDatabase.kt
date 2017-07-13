package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game_neu.entity.Ball
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.game_neu.entity.powerup.PowerUp
import com.fabiantarrach.breakinout.util.GdxObjectMap
import com.fabiantarrach.breakinout.util.getOrPutIfAbscent
import ktx.collections.GdxArray
import ktx.collections.gdxArrayOf
import ktx.collections.isEmpty

class EntityDatabase {

	private val entities = GdxObjectMap<Class<out Entity>, GdxArray<Entity>>()

	fun add(entity: Entity) {
		entities.getOrPutIfAbscent(entity.javaClass, gdxArrayOf())
				.add(entity)
	}

	fun eachEntity(action: (Entity) -> Unit) =
			entities.values()
					.flatMap { it }
					.forEach(action)

	fun eachPowerUp(action: (PowerUp) -> Unit) =
			entities.values()
					.flatMap { it }
					.filter { it is PowerUp }
					.map { it as PowerUp }
					.forEach(action)

	fun <T : Entity> each(clazz: Class<T>, block: (T) -> Unit) =
			entities.get(clazz, gdxArrayOf())
					.map { clazz.cast(it) }
					.forEach(block)

	fun remove(entity: Entity) {
		entities.get(entity.javaClass)
				.removeValue(entity, true)
	}

	fun ifNoBalls(action: () -> Unit) {
		if (entities.get(Ball::class.java).isEmpty())
			action()
	}

	fun clear() {
		entities.clear()
	}

}