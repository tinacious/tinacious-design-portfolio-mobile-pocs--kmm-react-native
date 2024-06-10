package com.tinaciousdesign.portfoliokmm.android.components

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun ComposeWebView(url: String) {
    val tag = "ComposeWebView"

    AndroidView(factory = {
        WebView(it).apply {
            webChromeClient = CustomWebViewClient(url) { externalUrl ->
                try {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(externalUrl)
                    }
                    context.startActivity(intent)
                } catch (e: Exception) {
                    Log.e(tag, "Cannot open external link: $externalUrl")
                }
            }
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.javaScriptEnabled = true

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                settings.isAlgorithmicDarkeningAllowed = true
            }
        }
    }, update = {
        it.loadUrl(url)
    })
}

class CustomWebViewClient(
    private val initialUrl: String,
    private val onOpenExternalLink: (String) -> Unit,
) : WebChromeClient() {
    override fun onReceivedTitle(view: WebView?, title: String?) {
        val url = view?.url ?: initialUrl
        if (url != initialUrl) {
            onOpenExternalLink(url)

            view?.loadUrl(initialUrl)
        }

        super.onReceivedTitle(view, title)
    }
}
