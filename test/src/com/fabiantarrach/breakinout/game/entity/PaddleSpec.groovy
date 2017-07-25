package com.fabiantarrach.breakinout.game.entity

import com.badlogic.gdx.graphics.Color
import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.goodie.Goodie
import com.fabiantarrach.breakinout.util.engine.EntityDatabase
import org.jetbrains.annotations.NotNull
import spock.lang.Specification

class PaddleSpec extends Specification {

   def fakeGoodie = new Goodie(new Rectangle(0, -0.75f, 0.5f, 0.1f)) {
        @Override
        void activate(@NotNull final EntityDatabase database) {}

        @Override
        protected Color getColor() { return null }
    }

    def obj = new Paddle()

    def """a paddle can be made wider"""() {
        when:
        def before = obj.shape.xAxis.width.value
        obj.bigger()

        then:
        obj.shape.xAxis.width.value > before
    }

    def """a paddle can be made shorter"""() {
        when:
        def before = obj.shape.xAxis.width.value
        obj.smaller()

        then:
        obj.shape.xAxis.width.value < before
    }

    def """Paddle Goodie collision"""() {
        given:
        def goodie = fakeGoodie

        when:
        def overlapped = false
        obj.ifOverlaps(goodie, { overlapped = true })

        then:
        overlapped == true
    }

    def """Paddle can bat the ball"""() {
        given:
        obj.velocity = new Velocity(-1f, 0f)
        def ball = new Ball(0f, 0f, new Velocity(1f, 1f))

        when:
        obj.bat(ball)

        then:
        ball.velocity.x.value == -1f
        ball.velocity.y.value == 1
    }

    def """Paddle can scrub the ball
            this means, that the velocity of the paddle gives a certain amount of his velocity to the ball
            the length of the velocity vector does not change"""() {

        given:
        obj.velocity = new Velocity(-1f, 0f)
        def ball = new Ball(0f, 0f, new Velocity(0f, 1f))
        def length = velocityLength(ball.velocity)

        when:
        obj.scrub(ball)

        then:
        ball.velocity.x.value < 0f
        ball.velocity.y.value < 1f
        length == velocityLength(ball.velocity)
    }

    private static float velocityLength(Velocity velocity) {
        return Math.sqrt(velocity.x.value * velocity.x.value + velocity.y.value * velocity.y.value).round(2)
    }
}