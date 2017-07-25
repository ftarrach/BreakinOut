package com.fabiantarrach.breakinout.game.component.rectangle

import spock.lang.Specification

class RectangleComponentSpec extends Specification {
    def "throw an exception if someone tries to create a Height with a negative value"() {
        when:
        new Height(-1f)

        then:
        thrown(IllegalArgumentException)
    }

    def "throw an exception if someone tries to create a Width with a negative value"() {
        when:
        new Width(-1f)

        then:
        thrown(IllegalArgumentException)
    }

}