package com.co.retrofit.app.feature.repositories

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.network.CacheManager
import com.co.retrofit.app.feature.network.NetworkServiceAdapter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ArtistRepository (private val application: Application){
    suspend fun refreshData():List<Artist> {
        var artists = getArtists()
        return if(artists.isNullOrEmpty()){
            val cm = application.baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if( cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_WIFI && cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_MOBILE){
                emptyList()
            } else {
                artists = NetworkServiceAdapter.getInstance(application).getArtists()
                addArtists(artists)
                artists
            }
        } else artists
    }

    suspend fun getArtists(): List<Artist>{
        val format = Json {  }
        val prefs = CacheManager.getPrefs(application.baseContext, CacheManager.ARTIST_SPREFS)
            val storedVal = prefs.getString("", "")
            if(!storedVal.isNullOrBlank()){
                return format.decodeFromString<List<Artist>>(storedVal)
        }
        return listOf<Artist>()
    }
    suspend fun addArtists( artists: List<Artist>){
        val format = Json {  }
        val prefs = CacheManager.getPrefs(application.baseContext, CacheManager.ARTIST_SPREFS)
            var store = format.encodeToString(artists)
            with(prefs.edit(),{
                putString("", store)
                apply()
            })

    }
}
