package com.fabiantarrach.breakinout

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Height
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.component.rectangle.Width
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y
import spock.lang.Specification

class RectangleSpec extends Specification {

    def obj = new Rectangle(
            new X(-1),
            new Y(-1),
            new Width(2),
            new Height(2))

    def """the constructor creates a rectangle using the x and y values the center of it
            the x and y values of the rectangle refer to the lower left corner"""(float x, float y, float w, float h, Tuple2<Float, Float> expectedLowerLeft) {
        expect:
        def rect = new Rectangle(x, y, w, h)
        rect.xAxis.x.value == expectedLowerLeft.first
        rect.yAxis.y.value == expectedLowerLeft.second

        where:
        x  | y | w | h || expectedLowerLeft
        0  | 0 | 1 | 1 || [-0.5, -0.5]
        0  | 1 | 1 | 1 || [-0.5, 0.5]
        1  | 0 | 1 | 1 || [0.5, -0.5]
        1  | 1 | 1 | 1 || [0.5, 0.5]

        0  | 0 | 2 | 2 || [-1, -1]
        0  | 1 | 2 | 2 || [-1, 0]
        1  | 0 | 2 | 2 || [0, -1]
        1  | 1 | 2 | 2 || [0, 0]

        -2 | 0 | 1 | 2 || [-2.5, -1]

    }

    def "ifOverlaps() checks whether a Rectangle overlaps with another Rectangle"(float x, float y, float w, float h, boolean expected) {

        expect:
        def result = false
        obj.ifOverlaps(new Rectangle(x, y, w, h)) { result = true }
        result == expected

        where:
        x     | y     | w  | h  || expected
        2f    | 2f    | 2f | 2f || false // corners
        2f    | -2f   | 2f | 2f || false
        -2f   | 2f    | 2f | 2f || false
        -2f   | -2f   | 2f | 2f || false

        2f    | 0f    | 2f | 2f || false // exakt on the side of
        0f    | 2f    | 2f | 2f || false
        -2f   | 0f    | 2f | 2f || false
        0f    | -2f   | 2f | 2f || false

        1.5f  | 0f    | 2f | 2f || true // side touches
        0f    | 1.5f  | 2f | 2f || true
        -1.5f | 0f    | 2f | 2f || true
        0f    | -1.5f | 2f | 2f || true

        1.5f  | 1.5f  | 2f | 2f || true // corner touches
        -1.5f | 1.5f  | 2f | 2f || true
        1.5f  | -1.5f | 2f | 2f || true
        -1.5f | -1.5f | 2f | 2f || true
    }

    def """ifNextTo() checks whether the given coordinates are next to the rectangle
            nextTo is defined as:
            - is on the same y-axis, same value excluded
            - is not on the same x-axis, same value included"""(float x, float y, Boolean expected) {
        expect:
        def result = null
        obj.ifNextTo(new X(x), new Y(y), { result = true }, { result = false })
        result == expected

        where:
        x    | y    || expected
        -2   | 0    || true // same
        -1   | 0    || true
        -0.5 | 0    || false
        0    | 0    || false
        0.5  | 0    || false
        1    | 0    || true
        2    | 0    || true

        -2   | 0.5  || true
        -1   | 0.5  || true
        -0.5 | 0.5  || false
        0    | 0.5  || false
        0.5  | 0.5  || false
        1    | 0.5  || true
        2    | 0.5  || true

        -2   | -0.5 || true
        -1   | -0.5 || true
        -0.5 | -0.5 || false
        0    | -0.5 || false
        0.5  | -0.5 || false
        1    | -0.5 || true
        2    | -0.5 || true

        -2   | -1   || false // under
        -1   | -1   || false
        -0.5 | -1   || false
        0    | -1   || false
        0.5  | -1   || false
        1    | -1   || false
        2    | -1   || false

        -2   | 1    || false // above
        -1   | 1    || false
        -0.5 | 1    || false
        0    | 1    || false
        0.5  | 1    || false
        1    | 1    || false
        2    | 1    || false
    }

    def "ifUnder() checks whether a given y-Value is under the Rectangle"(float y, boolean expected) {
        expect:
        def result = null
        obj.ifUnder(new Y(y), { result = true }, { result = false })
        result == expected

        where:
        y    || expected
        0    || false
        -0.5 || false
        -1   || false
        -2   || true
        -3   || true
    }

    def "move a rectangle by passing a velocity vector"(int x, int y, Tuple2<Float, Float> expectedLowerLeft) {
        expect:
        obj.move(new Velocity(x, y))
        obj.xAxis.x.value == expectedLowerLeft.first
        obj.yAxis.y.value == expectedLowerLeft.second

        where:
        x | y || expectedLowerLeft
        0 | 0 || [-1, -1]
        0 | 1 || [-1, 0]
        1 | 0 || [0, -1]
        1 | 1 || [0, 0]
        2 | 1 || [1, 0]
    }
}