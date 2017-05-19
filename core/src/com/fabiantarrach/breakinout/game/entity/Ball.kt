package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Area
import com.fabiantarrach.breakinout.game.component.Hitbox
import com.fabiantarrach.breakinout.game.component.Position
import com.fabiantarrach.breakinout.game.component.Size
import com.fabiantarrach.breakinout.game.renderer.Renderer

class Ball(position: Position, diameter: Float = 5f) :
		MoveableEntity(Area(position, Size.CircleSize(diameter)), Hitbox.CircularHitbox()) {

	override fun render(renderer: Renderer) {
		TODO("not implemented")
	}

}