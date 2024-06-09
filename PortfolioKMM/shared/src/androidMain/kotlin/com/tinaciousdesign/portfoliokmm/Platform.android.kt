package com.tinaciousdesign.portfoliokmm

actual class Platform actual constructor() {
    actual val name: String
        get() = "Android ${android.os.Build.VERSION.SDK_INT}"
}
