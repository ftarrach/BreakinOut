package com.fabiantarrach.breakinout.game.system.rendering

import com.badlogic.gdx.graphics.OrthographicCamera

class Camera(private val camera: OrthographicCamera) {

	constructor() : this(OrthographicCamera())

	fun projection() = camera.combined

}