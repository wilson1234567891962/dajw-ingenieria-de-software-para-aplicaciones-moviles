package com.co.retrofit.app.feature.repositories

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.android.volley.VolleyError
import com.co.retrofit.app.feature.database.dao.AlbumsOfArtistDao
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.network.CacheManager
import com.co.retrofit.app.feature.network.NetworkServiceAdapter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AlbumsOfArtistRepository (val application: Application, private val albumsOfArtistDao: AlbumsOfArtistDao) {


    suspend fun refreshData(artistId: Int): List<Album>{
        var cached = albumsOfArtistDao.getAlbumsOfArtist(artistId)
        return if(cached.isNullOrEmpty()){
            val cm = application.baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if( cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_WIFI && cm.activeNetworkInfo?.type != ConnectivityManager.TYPE_MOBILE){
                emptyList()
            } else {
                cached = NetworkServiceAdapter.getInstance(application).getAlbumsOfArtist(artistId)
                insertAlbums(cached)
                cached
            }
        } else cached
    }

    private suspend fun insertAlbums(albums: List<Album>){
        for (album in albums) {
            albumsOfArtistDao.insert(album)
        }
    }

}