package com.co.retrofit.app.feature.repositories

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.co.retrofit.app.feature.model.dto.Collector
import com.co.retrofit.app.feature.network.CacheManager
import com.co.retrofit.app.feature.network.NetworkServiceAdapter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CollectorRepository(private  val application: Application) {
    suspend fun refreshData():List<Collector> {
        var collectors = getCollectors()
        return if(collectors.isNullOrEmpty()){
            val cm = application.baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if( cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_WIFI && cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_MOBILE){
                emptyList()
            } else {
                collectors = NetworkServiceAdapter.getInstance(application).getCollectors()
                addCollectors(collectors)
                collectors
            }
        } else collectors
    }

    suspend fun getCollectors(): List<Collector>{
        val format = Json {  }
        val prefs = CacheManager.getPrefs(application.baseContext, CacheManager.COLLECTOR_SPREFS)
        val storedVal = prefs.getString("", "")
        if(!storedVal.isNullOrBlank()){
            return format.decodeFromString<List<Collector>>(storedVal)
        }
        return listOf<Collector>()
    }
    suspend fun addCollectors( collectors: List<Collector>){
        val format = Json {  }
        val prefs = CacheManager.getPrefs(application.baseContext, CacheManager.COLLECTOR_SPREFS)
        var store = format.encodeToString(collectors)
        with(prefs.edit(),{
            putString("", store)
            apply()
        })

    }
}