package com.fabiantarrach.breakinout.util

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Array as GdxArray

operator fun Vector2.plus(other: Vector2) {
	Vector2(x + other.x, y + other.y)
}

operator fun Vector2.minus(other: Vector2) {
	Vector2(x - other.x, y - other.y)
}
