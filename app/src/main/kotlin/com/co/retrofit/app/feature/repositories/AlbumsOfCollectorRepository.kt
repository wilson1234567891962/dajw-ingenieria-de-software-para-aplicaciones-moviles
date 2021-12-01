package com.co.retrofit.app.feature.repositories

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.co.retrofit.app.feature.database.dao.AlbumsOfCollectorDao
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.network.NetworkServiceAdapter

class AlbumsOfCollectorRepository (val application: Application, private val albumsOfCollectorDao: AlbumsOfCollectorDao) {


    suspend fun refreshData(collectorId: Int): List<Album>{
        var cached = albumsOfCollectorDao.getAlbumsOfCollector(collectorId)
        return if(cached.isNullOrEmpty()){
            val cm = application.baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if( cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_WIFI && cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_MOBILE){
                emptyList()
            } else {
                cached = NetworkServiceAdapter.getInstance(application).getAlbumsOfCollector(collectorId)
                insertAlbums(cached)
                cached
            }
        } else cached
    }

    private suspend fun insertAlbums(albums: List<Album>){
        for (album in albums) {
            albumsOfCollectorDao.insert(album)
        }
    }

}