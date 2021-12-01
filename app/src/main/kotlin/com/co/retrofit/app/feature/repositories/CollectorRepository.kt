package com.co.retrofit.app.feature.repositories

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.co.retrofit.app.feature.database.dao.CollectorsDao
import com.co.retrofit.app.feature.model.dto.Collector
import com.co.retrofit.app.feature.network.NetworkServiceAdapter


class CollectorRepository(val application: Application, private val collectorsDao: CollectorsDao) {
    suspend fun refreshData(): List<Collector> {
        var cached = collectorsDao.getCollectors()
        return if (cached.isNullOrEmpty()) {
            val cm =
                application.baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_WIFI && cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_MOBILE) {
                emptyList()
            } else {
                cached = NetworkServiceAdapter.getInstance(application).getCollectors()
                insertCollectors(cached)
                cached
            }
        } else cached
    }
    private suspend fun insertCollectors(collectors: List<Collector>){
        for (collector in collectors) {
            collectorsDao.insert(collector)
        }
    }
}

