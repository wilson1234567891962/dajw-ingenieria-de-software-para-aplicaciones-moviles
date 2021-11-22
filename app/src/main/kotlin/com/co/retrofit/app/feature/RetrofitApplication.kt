package com.co.retrofit.app.feature

import android.app.Application
import com.co.retrofit.app.feature.database.dao.VinylRoomDatabase
import com.co.retrofit.data.setupBackend

class RetrofitApplication : Application() {

    val database by lazy { VinylRoomDatabase.getDatabase(this) }

    override fun onCreate() {
        super.onCreate()

        // setup retrofit
        setupBackend()
    }

}