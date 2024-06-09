package com.tinaciousdesign.portfoliokmm.networking.responses

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val url: String,
    val title: String?,
    val altText: String?,
)
