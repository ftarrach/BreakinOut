package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.math.Factor
import com.fabiantarrach.breakinout.util.math.X

class XAxis(private var x: X,
            private var width: Width) {

	constructor(x: Float, width: Float) : this(X(x), Width(width))

	fun ifOverlaps(other: XAxis, then: () -> Unit) =
			x.ifLeftOf(other.x + other.width,
					then = {
						(x + width).ifRightOf(other.x, {
							then()
						})
					})

	fun shorter(factor: Factor) {
		width = width.shorter(factor)
		x += width.differenceTo(width)
				.halve()
	}

	fun wider(factor: Factor) {
		val newWidth = width.wider(factor)
		x -= width.differenceTo(newWidth)
				.halve()
		width = newWidth
	}

	fun update(gdxRectangle: GdxRectangle) {
		x.update(gdxRectangle)
		width.update(gdxRectangle)
	}

	fun move(velocity: Velocity): XAxis {
		x = velocity.move(x)
		return XAxis(x, width)
	}

	fun centeredHalve(): XAxis {
		val dropWidth = width.halve()
		val differenceToDropWidth = width.differenceTo(dropWidth)
		val dropX = x + differenceToDropWidth.halve()
		return XAxis(dropX, dropWidth)
	}

	fun ifContains(other: X, then: () -> Unit, orElse: () -> Unit) =
			x.ifLeftOf(other,
					then = {
						(x + width).ifRightOf(other, then, orElse)
					},
					orElse = orElse)

	fun relativeTo(other: X): X {
		val center = x + width.halve()
		val relative = (other - center) / width
		return relative.double()
	}
}