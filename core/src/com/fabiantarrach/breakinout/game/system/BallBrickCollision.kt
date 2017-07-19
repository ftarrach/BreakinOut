package com.fabiantarrach.breakinout.game.system

import com.badlogic.gdx.Gdx
import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class BallBrickCollision : LogicSystem() {

	// TODO: wrap booleans
	private var overlapped = false
	private var sideCollision = false

	override fun update(delta: Timespan) =
			database.each(Ball::class.java) {
				checkBrick(it)
			}

	private fun checkBrick(ball: Ball) {
		reset()
		database.each(Brick::class.java) {
			checkOverlap(ball, it)
		}
		if (overlapped)
			bounce(ball)
	}

	private fun reset() {
		overlapped = false
		sideCollision = false
	}

	private fun bounce(ball: Ball) = ball.bounceOffFront()

	private fun checkOverlap(ball: Ball, brick: Brick) =
			ball.ifOverlaps(brick) {
				println("${Gdx.graphics.frameId}: overlap")
				overlapped = true
				resolveOperlap(ball, brick)
				hitBrick(brick)
			}

	private fun resolveOperlap(ball: Ball, brick: Brick) =
			ball.ifUnder(brick,
					then = {
						ball::bounceOffSide
						sideCollision = true
					}
			) {
				println("${Gdx.graphics.frameId}: front hit")
				ball.bounceOffFront()
			}

	private fun hitBrick(brick: Brick) {
		brick.hit {
			createPowerUp(brick)
		}
	}

	private fun createPowerUp(brick: Brick) {
		if (Math.random() < 0.2f)
			database.add(
					brick.createPowerUp())
	}
}