package com.co.retrofit.app.feature.repositories

import android.app.Application
import android.util.Log
import com.android.volley.VolleyError
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.network.CacheManager
import com.co.retrofit.app.feature.network.NetworkServiceAdapter

class AlbumsOfArtistRepository (val application: Application) {

    suspend fun refreshData(artistId: Int):List<Album> {
        var potentialResp = CacheManager.getInstance(application.applicationContext).getAlbumsOfArtist(artistId)
        if(potentialResp.isEmpty()){
            Log.d("Cache decision", "get from network")
            var albumsOfArtist = NetworkServiceAdapter.getInstance(application).getAlbumsOfArtist(artistId)
            CacheManager.getInstance(application.applicationContext).addAlbumsOfArtist(artistId, albumsOfArtist)
            return albumsOfArtist
        }
        else{
            Log.d("Cache decision", "return ${potentialResp.size} elements from cache")
            return potentialResp
        }


    }


}