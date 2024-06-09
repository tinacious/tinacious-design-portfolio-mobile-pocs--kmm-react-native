package com.tinaciousdesign.portfoliokmm.android.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.tinaciousdesign.portfoliokmm.networking.responses.PortfolioItem

@Composable
fun PortfolioItemCard(portfolioItem: PortfolioItem) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = portfolioItem.featuredImage.url,
            contentDescription = portfolioItem.featuredImage.altText,
        )
        Text(
            text = portfolioItem.title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 0.dp,
                ),
        )
        Text(
            text = portfolioItem.excerptHtml,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 16.dp,
                ),
        )
    }
}
