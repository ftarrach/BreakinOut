package com.fabiantarrach.breakinout.game.meta.pipe

import com.fabiantarrach.breakinout.game.component.Shape

class AlgorithmNotFound(one: Shape, another: Shape) :
		RuntimeException("no collision algorithm found for ${one::class} and ${another::class}")