package com.example.koin

import org.koin.dsl.module

val myModule = module {
    single { AA() }

    factory { BB(get())}
}