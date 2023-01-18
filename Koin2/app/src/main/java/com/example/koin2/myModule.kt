package com.example.koin2

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { SampleRepository() }
    factory { SampleController(get()) }
}