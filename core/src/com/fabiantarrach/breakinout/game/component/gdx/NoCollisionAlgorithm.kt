package com.fabiantarrach.breakinout.game.component.gdx

class NoCollisionAlgorithm(shape1: Shape, shape2: Shape) : RuntimeException("no collision algorithm found for [${shape1.javaClass} to ${shape2.javaClass}]")