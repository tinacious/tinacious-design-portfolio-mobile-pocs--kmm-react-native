package com.tinaciousdesign.portfoliokmm.networking.responses

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioItem(
    val title: String,
    val slug: String,
    val launchDate: String,
    val showLaunchDate: Boolean,
    val isFeatured: Boolean? = false,
    val contentHtml: String,
    val excerptHtml: String,
    val website: String,
    val categories: List<Category>,
    val images: List<Image>,
    val featuredImage: Image,
)
