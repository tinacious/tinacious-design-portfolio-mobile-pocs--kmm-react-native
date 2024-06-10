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

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf<Route>(
        Route.PortfolioScreen,
        Route.ServicesScreen,
        Route.TechnologiesScreen,
        Route.AboutScreen,
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
            )
        }
    }
}
