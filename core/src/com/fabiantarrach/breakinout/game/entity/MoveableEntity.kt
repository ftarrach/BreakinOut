package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Area
import com.fabiantarrach.breakinout.game.component.Hitbox
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.data.Angle
import com.fabiantarrach.breakinout.game.data.Speed
import com.fabiantarrach.breakinout.util.Milliseconds

abstract class MoveableEntity(area: Area, hitbox: Hitbox<*>) : Entity(area, hitbox) {
	protected val velocity = Velocity()
	protected val speed: Speed = Speed(10f)

	fun move(delta: Milliseconds) {
		if (velocity.isMoving()) {
			area.moveBy(velocity, delta)
			hitbox.update(area)
		}
	}

	fun moveToX(target: Float) {
		val diff = area.getXOffsetTo(target)
		velocity.angle(speed * diff, Angle(0f))
	}

	fun moveWithAngle(angle: Angle) = velocity.angle(speed, angle)

	fun bounceOff(other: Entity) = when {
		isTopOrBottomOf(other) -> {
			val relative = measureRelativePositionX(other)
			velocity.invertY()
			velocity.addAngle(Angle(relative * 20f))
		}
		isLeftOrRightOf(other) -> {
			velocity.invertX()
		}
		else -> TODO("corner case")
	}

	fun bounceOff(other: MoveableEntity) {
		bounceOff(other as Entity)
		if (velocity.isMoving()) {
			// TODO: other.currentSpeed influence
		}
	}
}
