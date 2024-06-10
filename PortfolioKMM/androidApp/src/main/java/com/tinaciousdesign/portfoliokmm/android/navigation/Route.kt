package com.tinaciousdesign.portfoliokmm.android.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.DataObject
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
    data object PortfolioRoute : Route() {
        override val title: String get() = "Portfolio"

        override val icon: @Composable () -> Unit
            get() = { Icon(imageVector = Icons.Outlined.Palette, contentDescription = title) }
    }

    @Serializable
    data class PortfolioDetailRoute(
        val portfolioItemJson: String,
//        val portfolioItem: PortfolioItem,
    ) : Route() {
        override val title: String get() = portfolioItem?.title ?: "Portfolio"

        override val icon: @Composable () -> Unit
            get() = { Icon(imageVector = Icons.Outlined.Palette, contentDescription = title) }

        private val portfolioItem: PortfolioItem? get() = PortfolioItem.fromJson(portfolioItemJson)
    }

    @Serializable
    data object ServicesRoute : Route() {
        override val title: String get() = "Services"

        override val icon: @Composable () -> Unit
            get() = { Icon(imageVector = Icons.Outlined.ShoppingBasket, contentDescription = title) }
    }


    @Serializable
    data object TechnologiesRoute : Route() {
        override val title: String get() = "Technologies"

        override val icon: @Composable () -> Unit
            get() = { Icon(imageVector = Icons.Outlined.Build, contentDescription = title) }
    }

    @Serializable
    data object AboutRoute : Route() {
        override val title: String get() = "About"

        val externalUrl: String = "https://tinaciousdesign.com"

        override val icon: @Composable () -> Unit = { TinaciousDesignIcon() }
    }

    @Serializable
    data object CodeRoute : Route() {
        override val title: String get() = "Code"

        val externalUrl: String = "https://github.com/tinacious/tinacious-design-portfolio-mobile-pocs/tree/main/PortfolioKMM"

        override val icon: @Composable () -> Unit
            get() = { Icon(imageVector = Icons.Outlined.DataObject, contentDescription = TechnologiesRoute.title) }
    }
}
