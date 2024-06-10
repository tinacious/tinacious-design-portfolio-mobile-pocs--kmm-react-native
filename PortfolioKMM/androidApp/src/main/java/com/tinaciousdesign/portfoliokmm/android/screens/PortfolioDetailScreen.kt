package com.tinaciousdesign.portfoliokmm.android.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.tinaciousdesign.portfoliokmm.android.components.ComposeWebView
import com.tinaciousdesign.portfoliokmm.networking.responses.PortfolioItem

@Composable
fun PortfolioDetailScreen(
    portfolioItemJson: String,
    navController: NavController,
//    portfolioItem: PortfolioItem,
) {
    // Don't render the screen if we don't have a portfolio item.
    val portfolioItem = PortfolioItem.fromJson(portfolioItemJson) ?: run {
        navController.popBackStack()
        return
    }
    
    ComposeWebView(url = "https://tinaciousdesign.com/portfolio/${portfolioItem.slug}?minimal=1")
}
