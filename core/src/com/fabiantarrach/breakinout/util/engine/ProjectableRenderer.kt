package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.system.rendering.Renderer
import com.fabiantarrach.breakinout.util.screen.Camera

interface ProjectableRenderer : Renderer {
	fun project(camera: Camera)
}