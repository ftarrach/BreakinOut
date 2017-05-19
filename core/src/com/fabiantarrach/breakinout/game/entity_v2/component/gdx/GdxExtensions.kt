package com.fabiantarrach.breakinout.game.entity_v2.component.gdx

import com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Dimension
import com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Intersection
import com.fabiantarrach.breakinout.game.entity_v2.component.euclid.Position
import com.badlogic.gdx.math.Rectangle as GdxRectangle

fun GdxRectangle.toIntersection() = Intersection(Position(x, y), Dimension(x, y))