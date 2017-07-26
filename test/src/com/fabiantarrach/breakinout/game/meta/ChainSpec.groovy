package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.game.meta.chain.Chain
import com.fabiantarrach.breakinout.game.meta.chain.ErrorLink
import com.fabiantarrach.breakinout.game.meta.chain.Link
import kotlin.jvm.JvmClassMappingKt
import kotlin.jvm.functions.Function0
import org.jetbrains.annotations.NotNull
import spock.lang.Specification

class ChainSpec extends Specification {

    def "an empty chain"() {
        given:
        def weakChain = new TestChain()

        when:
        weakChain.process(new Object(), new Object(), {}, {})

        then:
        notThrown(Exception)
    }

    def "a weak chain: has elements, but doesn't throw an error if no link matches the input"() {
        given:
        def weakChain = new TestChain(new ForwardLink())

        when:
        weakChain.process(new Object(), new Object(), {}, {})

        then:
        !weakChain.links.isEmpty()
        notThrown(Exception)
    }

    def "a chain with an handler in the end throwing an exception"() {
        given:
        def strongChain = new TestChain(new ForwardLink(), new ErrorLink(JvmClassMappingKt.getKotlinClass(Chain)))

        when:
        strongChain.process(new Object(), new Object(), {}, {})

        then:
        thrown(Exception)
    }

    private class TestChain extends Chain {
        private List<Link> links

        TestChain(Link... links) { this.links = links.toList() }

        @Override
        protected List<Link> getLinks() { links }
    }

    private class ForwardLink implements Link {
        @Override
        void resolve(
                final Object one,
                final Object another,
                @NotNull final Function0 then,
                @NotNull final Function0 orElse, @NotNull final Function0 next) {
            next.invoke().resolve(one, another, then, orElse, next)
        }
    }
}