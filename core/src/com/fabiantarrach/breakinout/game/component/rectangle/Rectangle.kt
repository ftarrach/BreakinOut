package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.game.component.Shape
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.circle.Circle
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.math.Factor
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y
import com.fabiantarrach.breakinout.util.rect

class Rectangle(private var xAxis: XAxis,
                private var yAxis: YAxis) : Shape() {

	constructor(x: Float, y: Float, width: Float, height: Float) :
			this(XAxis(x - width / 2, width),
					YAxis(y - height / 2, height))

	constructor(x: X, y: Y, width: Width, height: Height) :
			this(XAxis(x, width),
					YAxis(y, height))

	fun ifOverlaps(other: Rectangle, then: () -> Unit) =
			xAxis.ifOverlaps(other.xAxis) {
				yAxis.ifOverlaps(other.yAxis, then)
			}

	fun ifNextTo(x: X, y: Y, then: () -> Unit, orElse: () -> Unit) =
			yAxis.ifContains(y,
					then = {
						xAxis.ifContains(x, orElse, then)
					},
					orElse = orElse)

	fun ifUnder(y: Y, then: () -> Unit, orElse: () -> Unit) =
			yAxis.ifUnder(y, then, orElse)

	fun createDrop(): Rectangle =
			Rectangle(
					xAxis.centeredHalve(),
					yAxis.thirdOf())

	fun createGdx(): GdxRectangle {
		val gdxRectangle = GdxRectangle()
		xAxis.update(gdxRectangle)
		yAxis.update(gdxRectangle)
		return gdxRectangle
	}

	fun shorten() = xAxis.shorter(Factor(1 / 1.25f))
	fun widen() = xAxis.wider(Factor(1.25f))

	override fun render(renderer: GdxShapeRenderer, color: GdxColor) {
		val rectangle = createGdx()
		renderer.rect(rectangle, color)
	}

	override fun move(velocity: Velocity) {
		xAxis = xAxis.move(velocity)
		yAxis = yAxis.move(velocity)
	}

	override fun relativeTo(x: X) = xAxis.relativeTo(x)

	override fun relativeTo(shape: Shape): X {
		if (shape is Circle)
			return shape.relativeTo(this)
		throw IllegalArgumentException("relativeTo between Rectangle and ${shape::javaClass} is not yet implemented")
	}

}