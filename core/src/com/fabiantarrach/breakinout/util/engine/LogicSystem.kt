package com.fabiantarrach.breakinout.util.engine

import com.badlogic.gdx.utils.Disposable

interface LogicSystem : Disposable {
	fun update(delta: Milliseconds)
}