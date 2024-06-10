package com.tinaciousdesign.portfoliokmm.android.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.ShoppingBasket
import androidx.compose.ui.graphics.vector.ImageVector
import com.tinaciousdesign.portfoliokmm.networking.responses.PortfolioItem
import kotlinx.serialization.Serializable


@Serializable
sealed class Route {
    abstract val icon: ImageVector
    abstract val title: String

    @Serializable
    data object PortfolioScreen : Route() {
        override val title: String get() = "Portfolio"
        override val icon: ImageVector get() = Icons.Outlined.Palette
    }

    @Serializable
    data class PortfolioDetailScreen(
        val portfolioItemJson: String,
//        val portfolioItem: PortfolioItem,
    ) : Route() {
        override val title: String get() = portfolioItem?.title ?: "Portfolio"
        override val icon: ImageVector get() = Icons.Outlined.Palette

        private val portfolioItem: PortfolioItem? get() = PortfolioItem.fromJson(portfolioItemJson)
    }

    @Serializable
    data object ServicesScreen : Route() {
        override val title: String get() = "Services"
        override val icon: ImageVector get() = Icons.Outlined.ShoppingBasket
    }

    @Serializable
    data object TechnologiesScreen : Route() {
        override val title: String get() = "Technologies"
        override val icon: ImageVector get() = Icons.Outlined.Build
    }
}
