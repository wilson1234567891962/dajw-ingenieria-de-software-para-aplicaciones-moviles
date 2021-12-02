package com.co.retrofit.app.feature.repositories

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.co.retrofit.app.feature.database.dao.ArtistsDao
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.network.NetworkServiceAdapter


class ArtistRepository (private val application: Application, private val artistsDao: ArtistsDao){
    suspend fun refreshData(): List<Artist> {
        var cached = artistsDao.getArtists()
        return if(cached.isNullOrEmpty()){
            val cm = application.baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if( cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_WIFI && cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_MOBILE){
                emptyList()
            } else {
                cached = NetworkServiceAdapter.getInstance(application).getArtists()
                insertArtists(cached)
                cached
            }
        } else cached
    }

    private suspend fun insertArtists(artists: List<Artist>){
        for (artist in artists) {
            artistsDao.insert(artist)
        }
    }
}