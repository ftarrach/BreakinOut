package com.fabiantarrach.breakinout.game.entity.goodie

import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.engine.EntityDatabase
import spock.lang.Specification

class SmallerPaddleSpec extends Specification {

    def obj = new SmallerPaddle(new Rectangle(0f, 0f, 0f, 0f))

    def "on activation, every paddle in the database will become smaller"() {
        given:
        def database = new EntityDatabase()
        def paddle = new Paddle()
        def widthBefore = paddle.shape.xAxis.width.value
        database.add(paddle)

        when:
        obj.activate(database)

        then:
        widthBefore > paddle.shape.xAxis.width.value
    }

}