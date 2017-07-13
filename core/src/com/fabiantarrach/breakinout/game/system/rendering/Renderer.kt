package com.fabiantarrach.breakinout.game.system.rendering

import com.fabiantarrach.breakinout.util.Entity
import com.fabiantarrach.breakinout.util.GdxDisposable

interface Renderer : GdxDisposable {

	fun render(entity: Entity)

	fun prepareRendering()
	fun endRendering()
}