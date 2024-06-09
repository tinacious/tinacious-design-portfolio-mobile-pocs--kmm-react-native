package com.tinaciousdesign.portfoliokmm.android

import android.app.Application
import com.tinaciousdesign.portfoliokmm.android.di.androidModule
import com.tinaciousdesign.portfoliokmm.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PortfolioKMMApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PortfolioKMMApplication)
            androidLogger()
            modules(appModule() + androidModule)
        }
    }
}