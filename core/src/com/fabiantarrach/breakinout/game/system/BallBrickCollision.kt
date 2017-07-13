package com.fabiantarrach.breakinout.game.system

import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.util.engine.LogicSystem
import com.fabiantarrach.breakinout.util.engine.Timespan

class BallBrickCollision : LogicSystem() {

	// TODO: wrap booleans
	private var overlapped = false
	private var sideCollision = false

	override fun update(delta: Timespan) =
			database.each(Ball::class.java) {
//				checkBrick(it)
			}

//	private fun checkBrick(ball: Ball) {
//		reset()
//		database.each(Brick::class.java) {
//			checkCollision(ball, it)
//		}
//		if (overlapped)
//			bounce(ball)
//	}
//
//	private fun reset() {
//		overlapped = false
//		sideCollision = false
//	}
//
//	private fun bounce(ball: Ball) =
//			ball.bounceOff(
//					PositionDifference(0f, sideCollision))
//
//	private fun checkCollision(ball: Ball, brick: Brick) =
//			ball.ifOverlaps(brick) {
//				overlapped = true
//				updateSideCollision(it)
//				hitBrick(brick)
//			}
//
//	private fun updateSideCollision(it: PositionDifference) =
//			it.ifSideCollision({
//				sideCollision = true
//			})
//
//	private fun hitBrick(brick: Brick) =
//			brick.hit {
//				createPowerUp(brick)
//			}
//
//	private fun createPowerUp(brick: Brick) {
//		if (Math.random() < 0.2f)
//			database.add(
//					brick.createPowerUp())
//	}
}