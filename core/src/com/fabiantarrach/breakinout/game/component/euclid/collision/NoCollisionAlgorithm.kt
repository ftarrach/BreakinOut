package com.fabiantarrach.breakinout.game.component.euclid.collision

import com.fabiantarrach.breakinout.game.component.euclid.hitbox.Hitbox

class NoCollisionAlgorithm(a: Hitbox, b: Hitbox) : RuntimeException("no collision algorithm in ${a::class} for ${b::class}")