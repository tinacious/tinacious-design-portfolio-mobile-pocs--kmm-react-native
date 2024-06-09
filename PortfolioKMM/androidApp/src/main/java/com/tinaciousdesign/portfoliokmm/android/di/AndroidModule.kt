package com.tinaciousdesign.portfoliokmm.android.di

import com.tinaciousdesign.portfoliokmm.Platform
import com.tinaciousdesign.portfoliokmm.networking.ApiClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val androidModule = module {
    singleOf(::Platform)
    singleOf(::ApiClient)
}