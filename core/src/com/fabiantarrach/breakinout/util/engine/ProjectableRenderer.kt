package com.fabiantarrach.breakinout.util.engine

import com.fabiantarrach.breakinout.game.system.rendering.Camera
import com.fabiantarrach.breakinout.game.system.rendering.Renderer

interface ProjectableRenderer : Renderer {
	fun project(camera: Camera)
}