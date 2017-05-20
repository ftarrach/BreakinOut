package com.fabiantarrach.breakinout.game.component.gdx

import com.fabiantarrach.breakinout.game.component.euclid.Dimension
import com.fabiantarrach.breakinout.game.component.euclid.Intersection
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.badlogic.gdx.math.Rectangle as GdxRectangle

fun GdxRectangle.toIntersection() = Intersection(Position(x, y), Dimension(width, height))