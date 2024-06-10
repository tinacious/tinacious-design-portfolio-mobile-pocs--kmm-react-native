package com.tinaciousdesign.portfoliokmm.android.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tinaciousdesign.portfoliokmm.android.R

@Composable
fun TinaciousDesignIcon() {
    val size = 24.dp

    Image(
        painterResource(R.drawable.tinacious_design_logo),
        "Tinacious Design logo",
        modifier = Modifier
            .width(size)
            .height(size)
    )
}
