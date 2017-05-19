package com.fabiantarrach.breakinout.game.systems

import com.badlogic.gdx.utils.Disposable
import com.fabiantarrach.breakinout.util.Milliseconds
import com.badlogic.gdx.utils.Array as GdxArray

interface LogicSystem : Disposable {
	fun update(delta: Milliseconds)
	override fun dispose() {}
}
