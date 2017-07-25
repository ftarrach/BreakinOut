package com.fabiantarrach.breakinout.game.entity

import spock.lang.Specification

class BrickSpec extends Specification {

    def obj = new Brick(0f, 0f, 1)

    def """when the hit() function is called, lifepoints decrease by 1.
             If the Brick dies because of the hit, maybe an powerup will be created"""() {
        when:
        def dead = false
        obj.hit({})
        obj.ifDead { dead = true }

        then:
        obj.life.points == 0
        dead == true
    }

}