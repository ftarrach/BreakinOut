package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.system.rendering.Brush

interface Entity {

	fun render(brush: Brush)

}