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

	override fun ifOverlaps(other: Shape, then: () -> Unit) {
		if (other is Rectangle)
			ifOverlaps(other, then)
	}

	override fun ifNextTo(other: Shape, then: () -> Unit, ifNot: () -> Unit) {
		if (other is Circle) {
			other.ifNextTo(this, then, ifNot)
			return
		}
		throw IllegalArgumentException("ifNextTo between Rectangle and ${other::javaClass} is not yet implemented")
	}

	override fun ifUnder(other: Shape, then: () -> Unit, ifNot: () -> Unit) {
		if (other is Circle) {
			other.ifUnder(this, then, ifNot)
			return
		}
		throw IllegalArgumentException("ifUnder between Circle and ${other::javaClass} is not yet implemented")
	}

	fun ifNextTo(x: X, y: Y, then: () -> Unit, orElse: () -> Unit) {
		yAxis.ifContains(y,
				then = { xAxis.ifContains(x, orElse, then) },
				orElse = orElse)
	}

	fun ifUnder(y: Y, then: () -> Unit, ifNot: () -> Unit) = yAxis.ifUnder(y, then, ifNot)

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

	override fun render(renderer: GdxShapeRenderer, color: GdxColor) {
		val rectangle = createGdx()
		renderer.rect(rectangle, color)
	}

	override fun move(velocity: Velocity) {
		xAxis = xAxis.move(velocity)
		yAxis = yAxis.move(velocity)
	}

	fun crub(velocity: Velocity): Velocity =
			velocity - xAxis.crub()

	fun relativeTo(x: X) = xAxis.relativeTo(x)

	override fun relativeTo(shape: Shape): X {
		if (shape is Circle)
			return shape.relativeTo(this)
		if (shape is Rectangle)
			return xAxis.relativeTo(shape.xAxis)
		return X(0f)
	}

}