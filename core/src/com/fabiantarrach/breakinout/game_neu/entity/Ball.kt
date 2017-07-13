package com.fabiantarrach.breakinout.game_neu.entity

import com.fabiantarrach.breakinout.game_neu.component.circle.Circle
import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxColor
import com.fabiantarrach.breakinout.util.GdxShapeRenderer
import com.fabiantarrach.breakinout.util.engine.Timespan

class Ball(x: Float, y: Float) : Entity() {

	private val circle = Circle(x, y, 0.025f)

	override fun update(delta: Timespan) {
//		TODO("not implemented")
	}

	override fun render(renderer: GdxShapeRenderer) {
		circle.render(renderer, GdxColor.RED)
	}

}