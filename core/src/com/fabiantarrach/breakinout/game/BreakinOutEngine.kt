package com.fabiantarrach.breakinout.game

import com.fabiantarrach.breakinout.game.component.euclid.Position
import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.game.system.EntityUpdate
import com.fabiantarrach.breakinout.game.system.PaddleBallCollision
import com.fabiantarrach.breakinout.game.system.rendering.RenderingSystem
import com.fabiantarrach.breakinout.util.engine.Engine
import com.fabiantarrach.breakinout.util.screen.Camera

class BreakinOutEngine(private val camera: Camera) : Engine() {

	init {
//		camera.area.set(0f, 280f, 0f)
	}

//	override fun registerSystems(systems: Array<LogicSystem>) {
//		systems.add(object : LogicSystem {
//			var t = 0f
//			override fun update(delta: Timespan) {
//				t += delta.floatValue()
//				if (t > 3) {
//					t = 0f
//					buildGame()
//				}
//			}
//		})
//		with(InputSystem(camera, { entities.paddles() })) {
//			systems.add(this)
//			Gdx.input.inputProcessor = this
//		}
//		systems.add(MoveEntities({ entities.moveableEntities() }))
//		systems.add(OuterBounds({ entities.moveableEntities() }))
//		systems.add(BallPaddleCollision({ Pair(entities.paddles(), entities.balls()) }))
//	}

	override fun buildGame() {
//		removeAllEntities()
		val paddle = Paddle(Position(0f, 0f))
		addEntity(paddle)

		// left
//		createBall(-60, 0) { moveWithAngle(Angle(0f))}
//		createBall(-70, 5) { moveWithAngle(Angle(0f))}
//		createBall(-70, -5) { moveWithAngle(Angle(0f)) }
//
//		// right
//		createBall(60, 0) { moveWithAngle(Angle(180f) )}
//		createBall(70, 5) { moveWithAngle(Angle(180f) )}
//		createBall(70, -5) { moveWithAngle(Angle(180f)) }
//
		// top
		(-200..200 step 20).forEach {
			createBall(it, 0.8f)
		}
		(-190..190 step 20).forEach {
			createBall(it, 0.9f)
		}
//		createBall(-200, 20)  { /*moveWithAngle(Angle(270f))*/ }
//		createBall(-150, 20)  { /*moveWithAngle(Angle(270f))*/ }
//		createBall(-100, 20)  { /*moveWithAngle(Angle(270f))*/ }
//		createBall(-50, 20)  { /*moveWithAngle(Angle(270f))*/ }
//		createBall(0, 20)    { /*moveWithAngle(Angle(270f))*/ }
//		createBall(50, 20)   { /*moveWithAngle(Angle(270f))*/ }
//		createBall(100, 20)   { /*moveWithAngle(Angle(270f))*/ }
//		createBall(150, 20)   { /*moveWithAngle(Angle(270f))*/ }
//		createBall(200, 20)   { /*moveWithAngle(Angle(270f))*/ }

//		// bottom
//		createBall(0, -20) { moveWithAngle(Angle(90f)) }
//		createBall(-50, -20) { moveWithAngle(Angle(90f)) }
//		createBall(50, -20) { moveWithAngle(Angle(90f)) }

		// top left to bottom right from top corner
//		createBall(-70, 25) { moveWithAngle(Angle(315f)) }

		// top left to bottom right
//		createBall(-50, 15) { moveWithAngle(Angle(315f)) }
//		createBall(-25, 15) { moveWithAngle(Angle(315f)) }
//		createBall(0, 15) { moveWithAngle(Angle(315f)) }
//		createBall(25, 15) { moveWithAngle(Angle(315f)) }
//		createBall(50, 15) { moveWithAngle(Angle(315f)) }

		addSystem(EntityUpdate())
		addSystem(PaddleBallCollision())
		addSystem(RenderingSystem(camera))
	}

	private fun createBall(x: Int, y: Float, block: Ball.() -> Unit = {}) {
		val ball = Ball(Position(x.toFloat(), y))
		block.invoke(ball)
		addEntity(ball)
	}

}