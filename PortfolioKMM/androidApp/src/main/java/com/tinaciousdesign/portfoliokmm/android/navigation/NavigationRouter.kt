package com.tinaciousdesign.portfoliokmm.android.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.tinaciousdesign.portfoliokmm.ApiUtils
import com.tinaciousdesign.portfoliokmm.android.screens.AboutScreen
import com.tinaciousdesign.portfoliokmm.android.screens.EmptyScreen
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

    NavHost(navController, startDestination = Route.PortfolioRoute) {
        composable<Route.PortfolioRoute> { backStackEntry ->
            HomeScreen(
                apiUtils = apiUtils,
                onPortfolioItemClicked = { portfolioItem ->
                    Log.d(TAG, "TODO: handle portfolio item clicked: $portfolioItem")
                    // Ideally we can use Parcelable and Parcelize for KMM classes
                    val route = Route.PortfolioDetailRoute(portfolioItem.toJson())
                    navController.navigate(route)
                },
            )
        }
        composable<Route.PortfolioDetailRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<Route.PortfolioDetailRoute>()
            PortfolioDetailScreen(route.portfolioItemJson, navController)
        }

        composable<Route.ServicesRoute> {
            EmptyScreen()
            /*ServicesScreen(
                apiUtils = apiUtils,
                onServiceClicked = { service ->
                    Log.d(TAG, "onServiceClicked: $service")
                }
            )*/
        }

        composable<Route.TechnologiesRoute> {
            EmptyScreen()
//            TechnologiesScreen(
//                apiUtils = apiUtils,
//            )
        }

        composable<Route.CodeRoute> {
            EmptyScreen()
        }

        composable<Route.AboutRoute> {
            EmptyScreen()
//            AboutScreen()
        }
    }
}
