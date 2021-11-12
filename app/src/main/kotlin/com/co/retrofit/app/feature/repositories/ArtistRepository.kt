package com.co.retrofit.app.feature.repositories

import android.app.Application
import android.util.Log
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.network.CacheManager
import com.co.retrofit.app.feature.network.NetworkServiceAdapter

class ArtistRepository (private val application: Application){
    suspend fun refreshData():List<Artist> {
        var potentialResp =
            CacheManager.getInstance(application.applicationContext).getArtists()
        if (potentialResp.isEmpty()) {
            Log.d("Cache decision", "get from network")
            var artists = NetworkServiceAdapter.getInstance(application).getArtists()
            CacheManager.getInstance(application.applicationContext).addArtists(artists)
            return artists
        } else {
            Log.d("Cache decision", "return ${potentialResp.size} elements from cache")
            return potentialResp
        }
    }
}