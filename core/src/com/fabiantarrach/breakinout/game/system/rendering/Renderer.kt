package com.fabiantarrach.breakinout.game.system.rendering

import com.badlogic.gdx.utils.Disposable
import com.fabiantarrach.breakinout.util.engine.SelectedEntities

interface Renderer : Disposable {

	fun render(entities: SelectedEntities)

}