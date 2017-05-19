package com.fabiantarrach.breakinout.game.renderer

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.utils.Disposable

interface Renderer : Disposable {
	fun useCamera(camera: OrthographicCamera)

	fun drawBox(rectangle: Rectangle, color: Color)
	fun drawCircle(circle: Circle, color: Color)
	fun drawLine(x: Float, y: Float, x2: Float, y2: Float)
}
