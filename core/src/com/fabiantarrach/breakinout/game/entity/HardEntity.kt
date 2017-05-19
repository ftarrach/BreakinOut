package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.euclid.Hitbox

abstract class HardEntity : Entity {

	protected abstract val hitbox: Hitbox

}