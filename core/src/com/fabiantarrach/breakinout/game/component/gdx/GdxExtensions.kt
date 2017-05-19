package com.fabiantarrach.breakinout.game.component.gdx

import com.fabiantarrach.breakinout.game.component.euclid.Dimension
import com.fabiantarrach.breakinout.game.component.euclid.Intersection
import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.badlogic.gdx.math.Rectangle as GdxRectangle

fun com.badlogic.gdx.math.Rectangle.toIntersection() = Intersection(com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Position(x, y), Dimension(x, y))