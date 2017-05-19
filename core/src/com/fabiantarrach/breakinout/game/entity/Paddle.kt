package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Area
import com.fabiantarrach.breakinout.game.component.Hitbox
import com.fabiantarrach.breakinout.game.component.Position
import com.fabiantarrach.breakinout.game.component.Size
import com.fabiantarrach.breakinout.game.renderer.Renderer

class Paddle(position: Position) :
		MoveableEntity(Area(position, Size.RectangleSize(100f, 10f)), Hitbox.RectangularHitbox()) {

	override fun render(renderer: Renderer) {
		TODO("not implemented")
	}

}