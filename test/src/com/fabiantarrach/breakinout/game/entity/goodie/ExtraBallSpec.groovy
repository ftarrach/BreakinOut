package com.fabiantarrach.breakinout.game.entity.goodie

import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.util.engine.EntityDatabase
import kotlin.jvm.JvmClassMappingKt
import spock.lang.Specification

class ExtraBallSpec extends Specification {

    def obj = new ExtraBall(new Rectangle(0f, 0f, 0f, 0f))

    def "create a new ball on activation"() {
        given:
        // TODO: extract an Interface from EntityDatabase, so I can Mock it
        def database = new EntityDatabase()
        def balls = 0

        when:
        obj.activate(database)

        then:
        database.each(JvmClassMappingKt.getKotlinClass(Ball.class)) {
            balls++
        }
        balls == 1
    }

}