package com.co.base.retrofit

import android.content.Context
import android.content.Intent

fun Context.intentWebView(): Intent {
    return Intent().setAction("$packageName.WEBVIEW")
}
