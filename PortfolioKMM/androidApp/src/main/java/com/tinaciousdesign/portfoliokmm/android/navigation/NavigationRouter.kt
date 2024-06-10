package com.tinaciousdesign.portfoliokmm.android.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.tinaciousdesign.portfoliokmm.ApiUtils
import com.tinaciousdesign.portfoliokmm.android.screens.HomeScreen
import com.tinaciousdesign.portfoliokmm.android.screens.PortfolioDetailScreen
import com.tinaciousdesign.portfoliokmm.android.screens.ServicesScreen
import com.tinaciousdesign.portfoliokmm.android.screens.TechnologiesScreen

@Composable
fun NavigationRouter(
    navController: NavHostController,
    apiUtils: ApiUtils,
) {
    val TAG = "MainActivity"

    NavHost(navController, startDestination = Route.PortfolioScreen) {
        composable<Route.PortfolioScreen> { backStackEntry ->
            HomeScreen(
                apiUtils = apiUtils,
                onPortfolioItemClicked = { portfolioItem ->
                    Log.d(TAG, "TODO: handle portfolio item clicked: $portfolioItem")
                    // Ideally we can use Parcelable and Parcelize for KMM classes
                    val route = Route.PortfolioDetailScreen(portfolioItem.toJson())
                    navController.navigate(route)
                },
            )
        }
        composable<Route.PortfolioDetailScreen> { backStackEntry ->
            val route = backStackEntry.toRoute<Route.PortfolioDetailScreen>()
            PortfolioDetailScreen(route.portfolioItemJson)
        }

        composable<Route.ServicesScreen> {
            ServicesScreen(
                apiUtils = apiUtils,
                onServiceClicked = { service ->
                    Log.d(TAG, "onServiceClicked: $service")
                }
            )
        }

        composable<Route.TechnologiesScreen> {
            TechnologiesScreen(
                apiUtils = apiUtils,
            )
        }
    }
}
