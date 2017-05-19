package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.system.rendering.RenderingToolbox

interface Entity {

	fun render(renderingTools: RenderingToolbox)

}