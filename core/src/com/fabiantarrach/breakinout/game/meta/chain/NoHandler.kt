package com.fabiantarrach.breakinout.game.meta.chain

import kotlin.reflect.KClass

class NoHandler(chainType: KClass<*>, one: Any, another: Any) :
		RuntimeException("no handler found in chain $chainType for $one and $another")