package com.co.base.retrofit.extension

import android.content.ContextWrapper
import android.content.res.TypedArray
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.annotation.StyleRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner

val View.owner: LifecycleOwner?
    get() = when (context) {
        is LifecycleOwner -> context as LifecycleOwner
        is ContextWrapper -> (context as ContextWrapper).baseContext as? LifecycleOwner
        else -> null
    }

val View.activity: AppCompatActivity?
    get() = when (context) {
        is AppCompatActivity -> context as AppCompatActivity
        is ContextWrapper -> (context as ContextWrapper).baseContext as? AppCompatActivity
        else -> null
    }

fun ActionBar?.enableBack() {
    if (this == null) return
    setDisplayHomeAsUpEnabled(true)
    setDisplayShowHomeEnabled(true)
}

@Suppress("DEPRECATION")
fun TextView.setCustomTextAppearance(@StyleRes styleRes: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) setTextAppearance(styleRes)
    else setTextAppearance(context, styleRes)
}

inline fun TypedArray.obtain(func: TypedArray.() -> Unit) {
    func()
    recycle()
}

