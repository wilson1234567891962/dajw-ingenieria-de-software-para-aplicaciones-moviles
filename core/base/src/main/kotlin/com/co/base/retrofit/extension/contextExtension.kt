package com.co.base.retrofit.extension

import android.content.Context

import android.widget.Toast
import androidx.annotation.StringRes

fun Context.toast(data: Any) = toast(data.toString())

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.toast(@StringRes msgRes: Int) = Toast.makeText(this, msgRes, Toast.LENGTH_SHORT).show()

fun Context.statusBarHeight(): Int {
    var result = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) result = resources.getDimensionPixelSize(resourceId)
    return result
}