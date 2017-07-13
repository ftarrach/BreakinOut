package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.game.component.Factor
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.rect

class Rectangle(x: Float, y: Float, width: Float, height: Float) {
	private val xAxis = XAxis(x - width / 2, width)
	private val yAxis = YAxis(y - height / 2, height)

	fun overlaps(other: Rectangle, then: () -> Unit) =
			xAxis.ifOverlaps(other.xAxis) {
				overlapsY(other, then)
			}

	private fun overlapsY(other: Rectangle, then: () -> Unit) =
			yAxis.ifOverlaps(other.yAxis) {
				then()
			}

	fun createGdx(): GdxRectangle {
		val gdxRectangle = GdxRectangle()
		xAxis.update(gdxRectangle)
		yAxis.update(gdxRectangle)
		return gdxRectangle
	}

	fun shorten() = xAxis.shorter(Factor(0.9f))
	fun widen() = xAxis.wider(Factor(1.1f))

	fun render(renderer: GdxShapeRenderer, color: GdxColor) {
		val rectangle = createGdx()
		renderer.rect(rectangle, color)
	}

}