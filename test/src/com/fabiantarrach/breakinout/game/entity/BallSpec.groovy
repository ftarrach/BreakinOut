package com.fabiantarrach.breakinout.game.entity

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.util.engine.Timespan
import spock.lang.Specification
import spock.lang.Unroll

class BallSpec extends Specification {

    @Unroll
    def "on update(), move the ball and bounce off, if it leaves the game"(
            float x, float y,
            float vx, float vy) {
        expect:
        def ball = new Ball(x, y, new Velocity(vx, vy))
        ball.update(new Timespan(1))
        ball.shape.position.x.value > -1f
        ball.shape.position.x.value < 1f
        ball.shape.position.y.value > -1f
        ball.shape.position.y.value < 1f

        where:
        x | y | vx | vy
        0 | 0 | 0  | 0
        0 | 0 | 0  | 1
        0 | 0 | 1  | 0
        0 | 0 | 1  | 1
        // too fast, right and top
        0 | 0 | 0  | 2
        0 | 0 | 2  | 0
        0 | 0 | 2  | 2
        // too fast, left and bottom
        0 | 0 | 0  | -2
        0 | 0 | -2 | 0
        0 | 0 | -2 | -2
    }

    def "check, whether the ball is next to or under the given paddle"(
            float x, float y, boolean isUnderOrNextTo) {
        given:
        def paddle = new Paddle()

        expect:
        def result = null
        new Ball(x, y, new Velocity(0f, 0f)).ifUnderFront(paddle, { result = true }, { result = false })
        isUnderOrNextTo == result

        where:
        x   | y     || isUnderOrNextTo
        0f  | 0f    || false
        0f  | 1f    || false
        1f  | 0f    || false
        1f  | 1f    || false
        0f  | -1f   || true
        -1f | 0f    || false
        -1f | -1f   || true
        1f  | -0.8f || true
        -1  | -0.8f || true
    }

}