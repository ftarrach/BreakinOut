package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.game.component.Factor
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.X
import com.fabiantarrach.breakinout.util.GdxRectangle

class XAxis(private var x: X,
            private var width: Width) {

	constructor(x: Float, width: Float) : this(X(x), Width(width))

	fun ifOverlaps(other: XAxis, then: () -> Unit) {
		if (x < other.x + width && x + width > other.x)
			then()
	}

	// TODO untested
	fun shorter(factor: Factor) {
		width = width.shorter(factor)
		x += width.difference(width)
				.halve()
	}

	// TODO untested
	fun wider(factor: Factor) {
		val newWidth = width.wider(factor)
		x -= width.difference(newWidth)
				.halve()
		width = newWidth
	}

	fun update(gdxRectangle: GdxRectangle) {
		x.update(gdxRectangle)
		width.update(gdxRectangle)
	}

	// TODO: very imperative. Can i make this better?
	fun crub() = x.crub() + width.halve().crub()

	fun move(velocity: Velocity): XAxis {
		x = velocity.move(x)
		return XAxis(x, width)
	}

	fun createDrop(): XAxis {
		val dropWidth = width.halve()
		val dropX = x + width.difference(dropWidth)
							 .halve()
		return XAxis(dropX, dropWidth)
	}

}