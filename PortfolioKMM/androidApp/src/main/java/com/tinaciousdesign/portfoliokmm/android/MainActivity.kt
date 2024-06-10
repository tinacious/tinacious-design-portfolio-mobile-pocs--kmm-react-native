package com.tinaciousdesign.portfoliokmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.tinaciousdesign.portfoliokmm.ApiUtils
import com.tinaciousdesign.portfoliokmm.android.navigation.BottomNavigationBar
import com.tinaciousdesign.portfoliokmm.android.navigation.NavigationRouter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PortfolioTheme(
                darkTheme = true, // Forcing dark mode because it's prettier. Remove this for system default.
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    val apiUtils = ApiUtils()

                    Scaffold(
                        bottomBar = {
                            BottomAppBar(modifier = Modifier) {
                                BottomNavigationBar(navController = navController)
                            }
                        },
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier.padding(
                                PaddingValues(
                                    0.dp,
                                    0.dp,
                                    0.dp,
                                    innerPadding.calculateBottomPadding()
                                )
                            )
                        ) {
                            NavigationRouter(
                                navController = navController,
                                apiUtils = apiUtils,
                            )
                        }
                    }
                }
            }
        }
    }
}
