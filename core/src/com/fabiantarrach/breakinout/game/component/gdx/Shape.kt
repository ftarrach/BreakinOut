package com.fabiantarrach.breakinout.game.component.gdx

import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush

interface Shape {
	fun render(brush: Brush)
	fun move(velocity: Velocity)
}