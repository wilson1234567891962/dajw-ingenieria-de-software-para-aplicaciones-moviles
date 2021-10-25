package com.co.retrofit.app.feature

import android.app.Application
import com.co.analytics.setupFireBase
import com.co.retrofit.data.setupBackend

class RetrofitApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // setup retrofit
        setupBackend()

        // setup Analytics
        setupFireBase()
    }
}