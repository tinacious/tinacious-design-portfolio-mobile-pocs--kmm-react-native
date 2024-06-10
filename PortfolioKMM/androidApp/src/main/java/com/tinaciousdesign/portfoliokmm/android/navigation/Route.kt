package com.tinaciousdesign.portfoliokmm.android.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.ShoppingBasket
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.tinaciousdesign.portfoliokmm.android.icons.TinaciousDesignIcon
import com.tinaciousdesign.portfoliokmm.networking.responses.PortfolioItem
import kotlinx.serialization.Serializable


@Serializable
sealed class Route {
    abstract val icon: @Composable () -> Unit
    abstract val title: String

    @Serializable
    data object PortfolioScreen : Route() {
        override val title: String get() = "Portfolio"

        override val icon: @Composable () -> Unit
            get() = { Icon(imageVector = Icons.Outlined.Palette, contentDescription = title) }
    }

    @Serializable
    data class PortfolioDetailScreen(
        val portfolioItemJson: String,
//        val portfolioItem: PortfolioItem,
    ) : Route() {
        override val title: String get() = portfolioItem?.title ?: "Portfolio"

        override val icon: @Composable () -> Unit
            get() = { Icon(imageVector = Icons.Outlined.Palette, contentDescription = title) }

        private val portfolioItem: PortfolioItem? get() = PortfolioItem.fromJson(portfolioItemJson)
    }

    @Serializable
    data object ServicesScreen : Route() {
        override val title: String get() = "Services"

        override val icon: @Composable () -> Unit
            get() = { Icon(imageVector = Icons.Outlined.ShoppingBasket, contentDescription = title) }
    }


    @Serializable
    data object TechnologiesScreen : Route() {
        override val title: String get() = "Technologies"

        override val icon: @Composable () -> Unit
            get() = { Icon(imageVector = Icons.Outlined.Build, contentDescription = title) }
    }

    @Serializable
    data object AboutScreen : Route() {
        override val title: String get() = "About"

        override val icon: @Composable () -> Unit = { TinaciousDesignIcon() }
    }
}
