package com.fabiantarrach.breakinout.game.component.euclid.hitbox

class NoCollisionAlgorithm(a: Hitbox, b: Hitbox) : RuntimeException("no collision algorithm in ${a::class} for ${b::class}")