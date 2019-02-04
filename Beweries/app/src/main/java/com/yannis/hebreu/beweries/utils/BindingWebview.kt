package com.yannis.hebreu.beweries.utils

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.BindingAdapter
import kotlinx.android.synthetic.main.activity_brewery_detail.*

@BindingAdapter("loadUrl")
fun loadUrl(view: WebView, websiteUrl: String?) {
    view.settings.javaScriptEnabled = true;
    view.settings.useWideViewPort = true;
    view.settings.setAppCacheEnabled(true)
    view.settings.domStorageEnabled = true
    view.settings.builtInZoomControls = true
    view.settings.javaScriptCanOpenWindowsAutomatically = true
    view.settings.loadWithOverviewMode = true;
    view.settings.setGeolocationEnabled(true)
    view.webViewClient = WebViewClient()
    view.loadUrl(websiteUrl)
}

