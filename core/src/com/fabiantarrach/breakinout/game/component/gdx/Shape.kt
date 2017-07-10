package com.fabiantarrach.breakinout.game.component.gdx

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.euclid.PositionDifference
import com.fabiantarrach.breakinout.game.component.euclid.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush

interface Shape {
	fun render(brush: Brush, color: Color)
	fun move(velocity: Velocity)
	fun ifOverlaps(other: Shape, action: (PositionDifference) -> Unit)
	fun ifOutsideGame(left: () -> Unit = {}, right: () -> Unit = {}, top: () -> Unit = {}, bottom: () -> Unit = {})
}