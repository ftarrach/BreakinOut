package com.fabiantarrach.breakinout.util.math

import com.fabiantarrach.breakinout.game.component.Velocity
import com.fabiantarrach.breakinout.game.entity.Ball
import com.fabiantarrach.breakinout.game.entity.Brick
import com.fabiantarrach.breakinout.game.entity.Paddle
import com.fabiantarrach.breakinout.util.engine.EntityStorage
import kotlin.jvm.JvmClassMappingKt
import kotlin.reflect.KClass
import spock.lang.Specification

class EntityStorageSpec extends Specification {

    private static final KClass<Paddle> PaddleClass = JvmClassMappingKt.getKotlinClass(Paddle.class)
    public static final KClass<Ball> BallClass = JvmClassMappingKt.getKotlinClass(Ball.class)
    public static final KClass<Brick> BrickClass = JvmClassMappingKt.getKotlinClass(Brick.class)

    def obj = new EntityStorage()

    def "ifNo executes the given closure if there are no elements of this entity type in the database"() {

        when:
        def noBalls = false
        obj.ifNo(BallClass, { noBalls = true })

        then:
        noBalls == true
    }

    def "store an entity"() {
        when:
        def paddle = new Paddle()
        obj.put(PaddleClass, paddle)

        then:
        def paddles = obj.entities.get(PaddleClass)
        paddles.size == 1
        paddles.contains(paddle)
    }

    def "clear the entity map"() {
        when:
        obj.put(PaddleClass, new Paddle())
        obj.put(BallClass, new Brick(0, 0, 0))
        obj.clear()

        then:
        obj.entities.values().flatten().size() == 0
    }

    def "entities can be removed by their reference"() {
        when:
        def paddle1 = new Paddle()
        def paddle2 = new Paddle()
        obj.put(PaddleClass, paddle1)
        obj.put(PaddleClass, paddle2)
        obj.remove(paddle1)

        then:
        def paddles = obj.entities.get(PaddleClass)
        paddles.size == 1
        paddles.first() == paddle2
    }

    def "each iterates over all stored entities of the given type"() {
        given:
        def paddle1 = new Paddle()
        def paddle2 = new Paddle()
        def paddle3 = new Paddle()
        def brick = new Brick(0, 0, 0)
        obj.put(PaddleClass, paddle1)
        obj.put(PaddleClass, paddle2)
        obj.put(PaddleClass, paddle3)
        obj.put(BrickClass, brick)

        when:
        def paddles = [paddle1, paddle2, paddle3]
        obj.each(PaddleClass, {
            removeIfContains(paddles, it)
        })

        then:
        paddles.isEmpty()
    }

    def "forEach iterates over all stored entities in the map"() {
        given:
        def paddle = new Paddle()
        def brick = new Brick(0, 0, 1)
        obj.put(PaddleClass, paddle)
        obj.put(BrickClass, brick)

        when:
        def entities = [paddle, brick]
        obj.forEach {
            removeIfContains(entities, it)
        }

        then:
        entities.isEmpty()
    }

    def """create a cross product of two entity types"""() {
        given:
        def paddle1 = new Paddle()
        def paddle2 = new Paddle()
        def ball1 = new Ball(0, 0, new Velocity(0, 0))
        def ball2 = new Ball(0, 0, new Velocity(0, 0))
        def ball3 = new Ball(0, 0, new Velocity(0, 0))
        obj.put(PaddleClass, paddle1)
        obj.put(PaddleClass, paddle2)
        obj.put(BallClass, ball1)
        obj.put(BallClass, ball2)
        obj.put(BallClass, ball3)

        when:
        def crossings = [
                [paddle1, ball1],
                [paddle1, ball2],
                [paddle1, ball3],
                [paddle2, ball1],
                [paddle2, ball2],
                [paddle2, ball3]
        ]
        obj.cross(PaddleClass, BallClass) { paddle, ball ->
            removeIfContains(crossings, [paddle, ball])
        }

        then:
        crossings.isEmpty()
    }

    private void removeIfContains(List<?> list, Object objectToRemove) {
        if (list.contains(objectToRemove))
            list.remove(objectToRemove)
        else
            threw new NoSuchElementException()
    }

}