package com.tinaciousdesign.portfoliokmm.android.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.tinaciousdesign.portfoliokmm.ApiUtils
import com.tinaciousdesign.portfoliokmm.networking.responses.ServiceItem


@Composable
fun ServicesScreen(
    apiUtils: ApiUtils,
    onServiceClicked: (ServiceItem) -> Unit,
) {
    Text("ServicesScreen")
}
