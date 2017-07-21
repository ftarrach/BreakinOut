package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.util.GdxCircle
import com.fabiantarrach.breakinout.util.GdxIntersector
import com.fabiantarrach.breakinout.util.GdxRectangle
import com.fabiantarrach.breakinout.util.ifTrue

class Intersection(private val circle: GdxCircle, private val rectangle: GdxRectangle) {
	fun ifOverlaps(then: () -> Unit) =
			GdxIntersector.overlaps(circle, rectangle)
					.ifTrue(then)
}