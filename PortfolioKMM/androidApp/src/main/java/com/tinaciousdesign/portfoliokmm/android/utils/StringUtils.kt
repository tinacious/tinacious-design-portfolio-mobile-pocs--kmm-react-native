package com.tinaciousdesign.portfoliokmm.android.utils

import androidx.core.text.HtmlCompat

/**
 * doesn't properly render HTML but is good enough for the excerpt
 */
fun String.showEscapedCharacters(): String =
    HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_COMPACT).toString()
