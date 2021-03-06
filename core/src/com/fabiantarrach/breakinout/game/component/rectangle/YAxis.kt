package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.math.Y

class YAxis(private var y: Y,
            private var height: Height) {

	constructor(y: Float, height: Float) : this(Y(y), Height(height))

	fun ifOverlaps(other: YAxis, then: () -> Unit) =
			y.ifUnder(other.y + other.height, then = {
				(y + height).ifOver(other.y, {
					then()
				})
			})

	fun update(rectangle: GdxRectangle) {
		y.update(rectangle)
		height.update(rectangle)
	}

	fun move(velocity: Velocity): YAxis {
		val y = velocity.move(y)
		return YAxis(y, height)
	}

	fun thirdOf(): YAxis {
		val dropHeight = height.third()
		return YAxis(y, dropHeight)
	}

	fun ifUnder(other: Y, then: () -> Unit, ifNot: () -> Unit) =
			y.ifOver(other, then, ifNot)

	fun ifContains(other: Y, then: () -> Unit, orElse: () -> Unit) =
			y.ifUnder(other,
					then = {
						(y + height).ifOver(other, then, orElse)
					},
					orElse = orElse)

}