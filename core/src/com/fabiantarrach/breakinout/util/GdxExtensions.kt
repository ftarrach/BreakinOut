package com.fabiantarrach.breakinout.util

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.ObjectMap
import com.badlogic.gdx.utils.Array as GdxArray

fun <T> GdxArray<T>.clone() = GdxArray<T>(this)

fun <K, V> ObjectMap<K, V>.getOrPutIfAbscent(key: K, value: V): V {
	if (!containsKey(key))
		put(key, value)
	return get(key, value)
}

typealias GdxShapeRenderer = ShapeRenderer
typealias GdxShapeType = ShapeRenderer.ShapeType