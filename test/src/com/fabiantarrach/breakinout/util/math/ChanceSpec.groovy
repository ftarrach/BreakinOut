package com.fabiantarrach.breakinout.util.math

import spock.lang.Specification


class ChanceSpec extends Specification {

    def "a 100% Chance will always call the given closure"() {
        given:
        def chance = new Chance(100)
        def success = false

        when:
        chance.ifSuccess({success = true})

        then:
        success == true
    }

    def "a 0% Chance will never call the given closure"() {
        given:
        def chance = new Chance(0)
        def success = false

        when:
        chance.ifSuccess({success = true})

        then:
        success == false
    }

}