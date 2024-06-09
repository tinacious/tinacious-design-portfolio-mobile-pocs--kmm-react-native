package com.tinaciousdesign.portfoliokmm.networking.responses

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioItem(
    val contentHtml: String,
)
