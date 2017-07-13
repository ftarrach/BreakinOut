package com.fabiantarrach.breakinout.util

import com.badlogic.gdx.graphics.Color
import ktx.app.copy

typealias GdxObjectMap<K, V> = com.badlogic.gdx.utils.ObjectMap<K, V>
typealias GdxScreen = com.badlogic.gdx.Screen
typealias GdxScreenAdapter = com.badlogic.gdx.ScreenAdapter
typealias GdxColor = com.badlogic.gdx.graphics.Color
typealias GdxBitmapFont = com.badlogic.gdx.graphics.g2d.BitmapFont
typealias GdxGlyphLayout = com.badlogic.gdx.graphics.g2d.GlyphLayout
typealias GdxSpriteBatch = com.badlogic.gdx.graphics.g2d.SpriteBatch
typealias GdxShapeRenderer = com.badlogic.gdx.graphics.glutils.ShapeRenderer
typealias GdxShapeType = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
typealias GdxCircle = com.badlogic.gdx.math.Circle
typealias GdxRectangle = com.badlogic.gdx.math.Rectangle
typealias GdxVector = com.badlogic.gdx.math.Vector2
typealias GdxVector3 = com.badlogic.gdx.math.Vector3
typealias GdxArray<T> = com.badlogic.gdx.utils.Array<T>
typealias GdxIntersector = com.badlogic.gdx.math.Intersector
typealias GdxDisposable = com.badlogic.gdx.utils.Disposable
typealias GdxOrthographicCamera = com.badlogic.gdx.graphics.OrthographicCamera

fun <K, V> GdxObjectMap<K, V>.getOrPutIfAbscent(key: K, value: V): V {
	if (!containsKey(key))
		put(key, value)
	return get(key, value)
}

fun GdxColor.darker(): GdxColor {
	val darkerColor = copy()
	darkerColor.r *= 0.7f
	darkerColor.g *= 0.7f
	darkerColor.b *= 0.7f
	return darkerColor
}

fun GdxShapeRenderer.rect(rectangle: GdxRectangle, color: Color) {
	this.color = color
	rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height)
}

fun GdxShapeRenderer.circle(circle: GdxCircle, color: Color) {
	this.color = color
	circle(circle.x, circle.y, circle.radius)
}