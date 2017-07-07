package com.fabiantarrach.breakinout.util

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.utils.ObjectMap

fun <K, V> ObjectMap<K, V>.getOrPutIfAbscent(key: K, value: V): V {
	if (!containsKey(key))
		put(key, value)
	return get(key, value)
}

typealias GdxShapeRenderer = ShapeRenderer
typealias GdxShapeType = ShapeRenderer.ShapeType
typealias GdxVector = Vector2
typealias GdxVector3 = Vector3
typealias GdxCircle = Circle
typealias GdxRectangle  = Rectangle
typealias GdxArray<T> = Array<T>