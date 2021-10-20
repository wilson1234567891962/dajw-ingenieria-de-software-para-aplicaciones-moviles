package com.co.base.retrofit

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onHomeClick()
        return super.onOptionsItemSelected(item)
    }

    protected open fun onHomeClick() = finish()

    open fun onEventMainThread(error: String) {

    }

    open fun onErrorReceived(error: Throwable) {

    }
}