package com.fabiantarrach.breakinout.game_neu.system.rendering

import com.fabiantarrach.breakinout.util.screen.Camera

interface ProjectableRenderer : Renderer {
	fun project(camera: Camera)
}