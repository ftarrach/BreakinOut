package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.system.rendering.Brush
import com.fabiantarrach.breakinout.util.engine.Timespan

interface Entity {
	fun update(delta: Timespan)
	fun render(brush: Brush)
	fun ifDead(action: () -> Unit)
}