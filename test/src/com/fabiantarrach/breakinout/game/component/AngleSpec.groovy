package com.fabiantarrach.breakinout.game.component

import com.badlogic.gdx.math.Vector2
import spock.lang.Specification


class AngleSpec extends Specification {

    def angle45 = new Angle(45)

    def "rotate the given Libgdx Vector2 by its angle. The returned object is not the given object"() {
        when:
        def gdxVector = new Vector2(1f, 0f)
        def rotatedVector = angle45.rotate(gdxVector)

        then:
        rotatedVector != gdxVector
        rotatedVector.x.trunc(2) == 0.70f
        rotatedVector.y.trunc(2) == 0.70f
    }
}