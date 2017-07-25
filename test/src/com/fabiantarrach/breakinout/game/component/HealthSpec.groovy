package com.fabiantarrach.breakinout.game.component

import spock.lang.Specification

class HealthSpec extends Specification {

    def "negative health is not allowed"() {
        when:
        new Health(-1)

        then:
        thrown(IllegalArgumentException)
    }

    def """ifDead() executes the given closure, if the healthpoints are lower than zero"""(Health health, boolean ifDead, boolean ifAlive) {

        expect:
        def alive = false
        def dead = false
        health.ifDead({ dead = true })
        health.ifAlive({ alive = true })
        dead == ifDead
        alive == ifAlive
        dead != alive // no schrödinger cats allowed

        where:
        health           || ifDead | ifAlive
        new Health(1)    || false  | true
        new Health(0)    || true   | false
        negativeHealth() || true   | false
    }

    private static Health negativeHealth() {
        def negativeHealth = new Health(0)
        negativeHealth.points = -1
        return negativeHealth
    }

    def "hit decrements 1 healthpoint and calls the given closure if health is now equal or lower than zero"(int health, boolean deadAfterHit) {
        expect:
        def dead = false
        def obj = new Health(health)
        obj.decrease({ dead = true })
        obj.points == health - 1
        dead == deadAfterHit

        where:
        health           || deadAfterHit
        3                || false
        2                || false
        1                || true
        0                || true
    }

}