package com.tinaciousdesign.portfoliokmm.android.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.tinaciousdesign.portfoliokmm.android.utils.openExternalBrowser

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf<Route>(
        Route.PortfolioRoute,
//        Route.ServicesScreen,
//        Route.TechnologiesScreen,
        Route.CodeRoute,
        Route.AboutRoute,
    )
    var selectedItem by remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = 1) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            items.forEachIndexed { index, navigationItem ->
                // todo: this won't work with proguard / R8
                if (navigationItem.javaClass.simpleName == destination.route?.split(".")?.last()) {
                    selectedItem = index
                }
            }
        }
    }

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                alwaysShowLabel = true,
                icon = item.icon,
                label = { Text(item.title) },
                selected = selectedItem == index,
                onClick = {
                    // Some items are external links
                    when (item) {
                        Route.CodeRoute -> {
                            navController.context.openExternalBrowser((item as Route.CodeRoute).externalUrl)
                        }
                        Route.AboutRoute -> {
                            navController.context.openExternalBrowser((item as Route.AboutRoute).externalUrl)
                        }
                        // These ones have normal routes
                        else -> {
                            selectedItem = index

                            navController.navigate(item) {
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                }
            )
        }
    }
}
