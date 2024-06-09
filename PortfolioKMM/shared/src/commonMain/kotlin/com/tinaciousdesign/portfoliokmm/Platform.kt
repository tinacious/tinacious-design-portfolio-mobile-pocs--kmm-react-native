package com.tinaciousdesign.portfoliokmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform