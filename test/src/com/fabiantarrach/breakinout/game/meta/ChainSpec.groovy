package com.fabiantarrach.breakinout.game.meta

import com.fabiantarrach.breakinout.game.meta.chain.Chain
import com.fabiantarrach.breakinout.game.meta.chain.Link
import com.fabiantarrach.breakinout.game.meta.chain.NoLinkFound
import com.fabiantarrach.breakinout.game.meta.chain.ErrorLink
import kotlin.jvm.JvmClassMappingKt
import kotlin.jvm.functions.Function0
import org.jetbrains.annotations.NotNull
import spock.lang.Specification

class ChainSpec extends Specification {

    def "a chain with an empty handler an the end"() {
        given:
        def weakChain = new Chain() {
            @Override
            protected List<Link> getElements() {
                return [new Link() {
                    @Override
                    void resolve(
                            final Object one,
                            final Object another,
                            @NotNull final Function0 then,
                            @NotNull final Function0 orElse, @NotNull final Function0 next) {
                        next.invoke()
                    }
                }]
            }
        }

        when:
        weakChain.process(new Object(), new Object(), {}, {})

        then:
        notThrown(NoLinkFound)
    }

    def "a chain with an handler in the end throwing an exception"() {
        given:
        def strongChain = new Chain() {
            @Override
            protected List<Link> getElements() {
                return [new Link() {
                    @Override
                    void resolve(
                            final Object one,
                            final Object another,
                            @NotNull final Function0 then,
                            @NotNull final Function0 orElse, @NotNull final Function0 next) {
                        next.invoke().resolve(one, another, then, orElse, next)
                    }
                }, new ErrorLink(JvmClassMappingKt.getKotlinClass(Object))]
            }
        }

        when:
        strongChain.process(new Object(), new Object(), {}, {})

        then:
        thrown(NoLinkFound)
    }

}