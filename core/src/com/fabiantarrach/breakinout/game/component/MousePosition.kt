package com.fabiantarrach.breakinout.game.component

import com.badlogic.gdx.Gdx
import com.fabiantarrach.breakinout.util.math.Vectorial
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y

class MousePosition(x: X, y: Y) : Vectorial(x, y) {

	constructor(x: Float, y: Float) : this(X(x),
			Y(y))

	constructor() : this(Gdx.input.x.toFloat(), Gdx.input.y.toFloat())

	fun moveVelocity() = Velocity(x, Y(0f))

}
