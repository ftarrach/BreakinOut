package com.fabiantarrach.breakinout.game_neu.component.rectangle

import com.fabiantarrach.breakinout.game_neu.component.Factor
import com.fabiantarrach.breakinout.game_neu.component.X
import com.fabiantarrach.breakinout.util.GdxRectangle

class XAxis(x: Float, width: Float) {
	private var x = X(x)
	private var width = Width(width)

	fun ifOverlaps(other: XAxis, then: () -> Unit) {
		if (x < other.x + width && x + width > other.x)
			then()
	}

	fun shorter(factor: Factor) {
		width = width.shorter(factor)
		x += width.difference(width)
				.halve()
	}

	fun wider(factor: Factor) {
		width = width.wider(factor)
		x -= width.difference(width)
				.halve()
	}

	fun update(gdxRectangle: GdxRectangle) {
		x.update(gdxRectangle)
		width.update(gdxRectangle)
	}

}