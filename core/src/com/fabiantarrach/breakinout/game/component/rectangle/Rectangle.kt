package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.game.component.Factor
import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.circle.Circle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.rect

class Rectangle(private var xAxis: XAxis,
                private var yAxis: YAxis) : Shape() {

	constructor(x: Float, y: Float, width: Float, height: Float) :
			this(XAxis(x - width / 2, width),
					YAxis(y - height / 2, height))

	override fun ifOverlaps(other: Shape, then: () -> Unit) {
		if (other is Rectangle)
			ifOverlaps(other, then)
	}

	override fun ifUnder(other: Shape, then: () -> Unit, ifNot: () -> Unit) {
		if (other is Circle)
			other.ifUnder(other, then, ifNot)
	}

	fun createDrop(): Rectangle =
			Rectangle(
					xAxis.createDrop(),
					yAxis.third())

	fun ifOverlaps(other: Rectangle, then: () -> Unit) =
			xAxis.ifOverlaps(other.xAxis) {
				overlapsY(other.yAxis, then)
			}

	private fun overlapsY(other: YAxis, then: () -> Unit) =
			yAxis.ifOverlaps(other, then)

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

	fun move(velocity: Velocity) {
		xAxis = xAxis.move(velocity)
		yAxis = yAxis.move(velocity)
	}

	fun crub(velocity: Velocity): Velocity =
			velocity - xAxis.crub()

}