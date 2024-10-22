package com.zenni.core.base

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val niaDispatcher: Dispatchers)

enum class Dispatchers {
    Default,
    IO,
}
