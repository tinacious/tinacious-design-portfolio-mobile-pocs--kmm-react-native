package com.tinaciousdesign.portfoliokmm.networking.responses

import kotlinx.serialization.Serializable

@Serializable
data class ServiceItem(
    val title: String,
    val body: String,
    val slug: String,
    val summary: String,
    val technologies: List<TechnologyItem>,
)
