package com.fabiantarrach.breakinout.game.component.circle

import spock.lang.Specification
import spock.lang.Unroll


class OutsideCircleSpec extends Specification {

    @Unroll
    def """the method ifOutsideGame() moves the circle back inside the game area and executes the corresponding closure"""(
            Circle obj, Circle corrected, boolean isLeft, boolean isTop, boolean isBottom, boolean isRight) {
        expect:
        def left = false
        def right = false
        def top = false
        def bottom = false
        obj.ifOutsideGame({ left = true }, { right = true }, { top = true }, { bottom = true })
        obj.position.x.value == corrected.position.x.value
        obj.position.y.value == corrected.position.y.value
        left == isLeft
        right == isRight
        top == isTop
        bottom == isBottom

        where:
        obj                  || corrected            | isLeft | isTop | isBottom | isRight
        new Circle(-2, 0, 1) || new Circle(-1, 0, 1) | true   | false | false    | false
        new Circle(0, 2, 1)  || new Circle(0, 1, 1)  | false  | true  | false    | false
        new Circle(0, -2, 1) || new Circle(0, -1, 1) | false  | false | true     | false
        new Circle(2, 0, 1)  || new Circle(1, 0, 1)  | false  | false | false    | true
    }

}