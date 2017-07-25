package com.fabiantarrach.breakinout.game.component.circle

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.component.rectangle.Height
import com.fabiantarrach.breakinout.game.component.rectangle.Rectangle
import com.fabiantarrach.breakinout.game.component.rectangle.Width
import com.fabiantarrach.breakinout.util.math.X
import com.fabiantarrach.breakinout.util.math.Y
import spock.lang.Specification

class CenteredCircleSpec extends Specification {

    // a centered circle is a circle on the coordinates (0,0)
    // in this specification it as a radius of 1
    def obj = new Circle(0, 0, 1)

    def "move a circle by passing a velocity vector"(int x, int y, CirclePosition newPosition) {

        expect:
        obj.move(new Velocity(x, y))
        obj.position == newPosition

        where:
        x  | y  || newPosition
        0  | 0  || new CirclePosition(x, y)
        0  | 1  || new CirclePosition(x, y)
        0  | -1 || new CirclePosition(x, y)
        1  | 0  || new CirclePosition(x, y)
        1  | 1  || new CirclePosition(x, y)
        1  | -1 || new CirclePosition(x, y)
        -1 | 0  || new CirclePosition(x, y)
        -1 | 1  || new CirclePosition(x, y)
        -1 | -1 || new CirclePosition(x, y)
    }

    def "transform the circle to a GdxCircle for libgdx interop"() {
        when:
        def gdx = obj.toGdxCircle()

        then:
        gdx.class == com.badlogic.gdx.math.Circle
        gdx.x == obj.position.x.value
        gdx.y == obj.position.y.value
    }

    def """executes given closure if rectangle is next to the circle
            next to is defined as:
               - center of circle shares value with the yAxis of the rectangle
               - center of circle doesn't share value with the xAxis of the rectangle
        """(float rectangleX, float rectangleY, boolean accept) {

        expect:
        def isNextTo = null
        obj.ifNextTo(new Rectangle(rectangleX, rectangleY, 1, 1), { isNextTo = true }, { isNextTo = false })
        isNextTo == accept

        where:
        rectangleX | rectangleY || accept
        0          | 0          || false
        0          | 1          || false
        0          | -1         || false
        1          | 0          || true
        1          | 1          || false
        1          | -1         || false
        -1         | 0          || true
        -1         | 1          || false
        -1         | -1         || false
    }

    def """executes given closure 'then' if circle is under the given rectangle 'orElse' otherwise
            under is defined as:
                - y value is smaller than the beginning of the yAxis of the rectangle
        """(float rectangleX, float rectangleY, boolean accept) {

        expect:
        def isUnder = null
        obj.ifUnder(new Rectangle(rectangleX, rectangleY, 1, 1), { isUnder = true }, { isUnder = false })
        isUnder == accept

        where:
        rectangleX | rectangleY || accept
        0          | 0          || false
        0          | 1          || true
        0          | -1         || false
        1          | 0          || false
        1          | 1          || true
        1          | -1         || false
        -1         | 0          || false
        -1         | 1          || true
        -1         | -1         || false
    }

    def """ifOverlaps checks whether a given rectangle overlaps with the circle"""(float x, float y, boolean expected) {

        expect:
        def rectangle = new Rectangle(new X(y), new Y(y), new Width(1), new Height(1))
        boolean overlaps = false
        obj.ifOverlaps(rectangle) { overlaps = true }
        expected == overlaps

        where:
        x  | y  || expected
        0  | 0  || true
        -1 | 0  || true
        0  | -1 || true
        -1 | -1 || true
        1  | 1  || false
        -2 | 1  || false
        -2 | -2 || false
        1  | -2 || false

    }

    def """the centered circle is not outside the game"""() {
        when:
        def left = false
        def right = false
        def top = false
        def bottom = false
        obj.ifOutsideGame({ left = true }, { right = true }, { top = true }, { bottom = true })

        then:
        left == false
        right == false
        top == false
        bottom == false
    }

}
