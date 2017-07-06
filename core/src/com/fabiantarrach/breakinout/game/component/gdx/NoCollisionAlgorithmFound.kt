package com.fabiantarrach.breakinout.game.component.gdx

class NoCollisionAlgorithmFound(shape1: Shape, shape2: Shape) : RuntimeException("no collision algorithm found for [${shape1.javaClass} ${shape2.javaClass}]")