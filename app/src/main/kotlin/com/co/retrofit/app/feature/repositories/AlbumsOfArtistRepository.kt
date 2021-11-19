package com.co.retrofit.app.feature.repositories

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.android.volley.VolleyError
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.network.CacheManager
import com.co.retrofit.app.feature.network.NetworkServiceAdapter
import kotlinx.serialization.json.Json

class AlbumsOfArtistRepository (val application: Application) {


    suspend fun refreshData(artistId: Int): List<Album>{
        var albumsOfArtist = getAlbumsOfArtist(artistId)
        return if(albumsOfArtist.isNullOrEmpty()){
            val cm = application.baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if( cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_WIFI && cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_MOBILE){
                emptyList()
            } else {
                albumsOfArtist = NetworkServiceAdapter.getInstance(application).getAlbumsOfArtist(artistId)
                addAlbumsOfArtist(artistId, albumsOfArtist)
                albumsOfArtist
            }
        } else albumsOfArtist
    }

    suspend fun getAlbumsOfArtist(artistId:Int): List<Album>{
        val format = Json {  }
        val prefs = CacheManager.getPrefs(application.baseContext, CacheManager.ARTISTS_SPREFS)
        if(prefs.contains(artistId.toString())){
            val storedVal = prefs.getString(artistId.toString(), "")
            if(!storedVal.isNullOrBlank()){
                return format.decodeFromString<List<Album>>(storedVal)
            }
        }
        return listOf<Album>()
    }


    suspend fun addAlbumsOfArtist(artistId:Int, albumsOfArtist: List<Album>){
        val format = Json {  }
        val prefs = CacheManager.getPrefs(application.baseContext, CacheManager.ARTISTS_SPREFS)
        if(!prefs.contains(artistId.toString())){
            var store = format.encodeToString(albumsOfArtist)
            with(prefs.edit(),{
                putString(artistId.toString(), store)
                apply()
            })
        }
    }


}