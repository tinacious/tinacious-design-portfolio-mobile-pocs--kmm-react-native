package com.tinaciousdesign.portfoliokmm.networking.responses

import kotlinx.serialization.Serializable

@Serializable
data class TechnologyItem(
    val title: String,
    val body: String,
    val slug: String,
    val isFeatured: Boolean,
)
