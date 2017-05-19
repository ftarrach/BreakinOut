package com.fabiantarrach.breakinout.game.system.rendering

import com.badlogic.gdx.utils.Disposable
import com.fabiantarrach.breakinout.game.entity.Entity

interface Renderer : Disposable {

	// TODO: Wrap up List<Entity>
	fun render(entities: List<Entity>)

}