package com.yannis.hebreu.beweries.utils

import android.webkit.WebView
import androidx.databinding.BindingAdapter

@BindingAdapter("loadUrl")
fun loadUrl(view: WebView, websiteUrl: String?) {
    view.loadUrl(websiteUrl)
}