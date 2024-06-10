package com.tinaciousdesign.portfoliokmm.android.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.tinaciousdesign.portfoliokmm.networking.responses.PortfolioItem

@Composable
fun PortfolioDetailScreen(
    portfolioItemJson: String,
//    portfolioItem: PortfolioItem,
) {
    // Don't render the screen if we don't have a portfolio item.
    val portfolioItem = PortfolioItem.fromJson(portfolioItemJson) ?: return

    Text("PortfolioDetailScreen: ${portfolioItem.title}")
}
