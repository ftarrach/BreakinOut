package com.fabiantarrach.breakinout.game.meta.overlap

import com.fabiantarrach.breakinout.game.component.Shape

class NoCollisionFound(one: Shape, another: Shape) :
		RuntimeException("no collision algorithm found for ${one::class} and ${another::class}")