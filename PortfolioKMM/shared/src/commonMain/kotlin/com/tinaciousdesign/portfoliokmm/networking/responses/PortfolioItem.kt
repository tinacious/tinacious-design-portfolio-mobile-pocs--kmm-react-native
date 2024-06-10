package com.tinaciousdesign.portfoliokmm.networking.responses

import co.touchlab.kermit.Logger
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

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
) {
    fun toJson(): String = Json.encodeToString(this)

    companion object {
        fun fromJson(json: String): PortfolioItem? {
            return try {
                Json.decodeFromString(json)
            } catch (e: Exception) {
                Logger.e(e) { "failed to decode PortfolioItem" }
                null
            }
        }
    }
}
