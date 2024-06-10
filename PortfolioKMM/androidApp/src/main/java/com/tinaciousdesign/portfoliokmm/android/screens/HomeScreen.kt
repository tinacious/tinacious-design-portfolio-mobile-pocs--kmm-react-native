package com.tinaciousdesign.portfoliokmm.android.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tinaciousdesign.portfoliokmm.ApiUtils
import com.tinaciousdesign.portfoliokmm.android.components.PortfolioItemCard
import com.tinaciousdesign.portfoliokmm.networking.responses.PortfolioItem
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    apiUtils: ApiUtils,
    onPortfolioItemClicked: (PortfolioItem) -> Unit,
) {
    val scope = rememberCoroutineScope()
    var portfolioItems by remember { mutableStateOf<List<PortfolioItem>>(emptyList()) }

    LaunchedEffect(true) {
        scope.launch {
            portfolioItems = apiUtils.getPortfolioItems()
        }
    }

    if (portfolioItems.isEmpty()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = "⏳ Loading...",
                textAlign = TextAlign.Center,
            )
        }
    }

    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 18.dp,
            horizontal = 18.dp,
        ),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(portfolioItems.size) { index ->
            val portfolioItem = portfolioItems[index]

            PortfolioItemCard(
                portfolioItem = portfolioItem,
                modifier = Modifier.clickable {
                    onPortfolioItemClicked(portfolioItem)
                }
            )
        }
    }
}
