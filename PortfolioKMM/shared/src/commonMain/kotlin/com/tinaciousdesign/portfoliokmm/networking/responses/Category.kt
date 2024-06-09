package com.tinaciousdesign.portfoliokmm.networking.responses

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val name: String,
    val slug: String,
)
