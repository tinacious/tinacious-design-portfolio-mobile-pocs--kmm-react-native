package com.tinaciousdesign.portfoliokmm.di

import com.tinaciousdesign.portfoliokmm.Platform
import com.tinaciousdesign.portfoliokmm.networking.ApiClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val platformModule = module {
    singleOf(::Platform)
}

val commonModule = module {
    singleOf(::ApiClient)
}

fun appModule() = listOf(
    commonModule,
    platformModule,
)
