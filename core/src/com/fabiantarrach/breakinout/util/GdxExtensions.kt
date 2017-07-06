package com.fabiantarrach.breakinout.util

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.utils.ObjectMap
import com.badlogic.gdx.utils.Array as GdxArray

fun <K, V> ObjectMap<K, V>.getOrPutIfAbscent(key: K, value: V): V {
	if (!containsKey(key))
		put(key, value)
	return get(key, value)
}

typealias GdxShapeRenderer = ShapeRenderer
typealias GdxShapeType = ShapeRenderer.ShapeType
typealias GdxVector3 = Vector3