package com.fabiantarrach.breakinout.game.component.rectangle

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.circle.Circle
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y
import spock.lang.Specification

class RectangleSpec extends Specification {

    /** a cube around the center of the coordinate system, spanning 1 in every direction */
    def centerCube = new Rectangle(
            new X(-1),
            new Y(-1),
            new Width(2),
            new Height(2))

    def obj = new Rectangle(
            new X(1),
            new Y(1),
            new Width(2),
            new Height(1))

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
        centerCube.ifOverlaps(new Rectangle(x, y, w, h)) { result = true }
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
        centerCube.ifNextTo(new X(x), new Y(y), { result = true }, { result = false })
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
        centerCube.ifUnder(new Y(y), { result = true }, { result = false })
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
        centerCube.move(new Velocity(x, y))
        centerCube.xAxis.x.value == expectedLowerLeft.first
        centerCube.yAxis.y.value == expectedLowerLeft.second

        where:
        x | y || expectedLowerLeft
        0 | 0 || [-1, -1]
        0 | 1 || [-1, 0]
        1 | 0 || [0, -1]
        1 | 1 || [0, 0]
        2 | 1 || [1, 0]
    }

    def "calculate the relative x-position of a circle to a rectangle"(float x, float y, float expected) {
        expect:
        def relatixeX = obj.relativeTo(new Circle(x, y, 1))
        relatixeX.value == expected

        where:
        x | y || expected
        1 | 0 || -1.0    // outer left
        2 | 0 || 0.0     // center
        3 | 0 || 1.0     // outer right
    }

    def "create a GdxRectangle with same values"() {
        when:
        def gdxRectangle = obj.createGdx()

        then:
        gdxRectangle.x == obj.xAxis.x.value
        gdxRectangle.y == obj.yAxis.y.value
        gdxRectangle.width == obj.xAxis.width.value
        gdxRectangle.height == obj.yAxis.height.value
    }

    def """create the Rectangle of the Goodie a block can drop
            - the width is a halve of the block's width
            - the height is a third of the block's height"""() {
        when:
        def drop = obj.createDrop()

        then:
        drop.xAxis.width.value == 1
        drop.yAxis.height.value.trunc(3) == 0.333f
    }

    def """a rectangle can be made wider"""() {
        when:
        def before = obj.xAxis.width.value
        obj.widen()

        then:
        obj.xAxis.width.value > before
    }

    def """a rectangle can be made shorter"""() {
        when:
        def before = obj.xAxis.width.value
        obj.shorten()

        then:
        obj.xAxis.width.value < before
    }

    def """a rectangle which is first widened and then shortened is equivalent to the base rectangle"""() {
        when:
        def baseWidth = obj.xAxis.width.value
        obj.widen()
        obj.shorten()
        obj.shorten()
        obj.widen()

        then:
        obj.xAxis.width.value == baseWidth
    }

}