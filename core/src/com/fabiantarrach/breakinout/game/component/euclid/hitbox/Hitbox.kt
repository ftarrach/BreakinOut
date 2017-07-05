package com.fabiantarrach.breakinout.game.component.euclid.hitbox

import com.fabiantarrach.breakinout.game.component.euclid.collision.Collision
import com.fabiantarrach.breakinout.game.component.moving.Velocity
import com.fabiantarrach.breakinout.game.system.rendering.Brush

interface Hitbox {
	fun render(brush: Brush)
	fun move(velocity: Velocity)
	fun ifOverlaps(other: Hitbox, ifCollision: (Collision) -> Unit)
}
