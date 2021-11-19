package com.co.retrofit.app.feature.network

import android.content.Context
import android.content.SharedPreferences
import com.co.retrofit.app.feature.model.dto.Album


class CacheManager(context: Context) {
    companion object{
        var instance: CacheManager? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: CacheManager(context).also {
                    instance = it
                }
            }

        const val APP_SPREFS = "com.co.retrofit.app"
        const val ARTISTS_SPREFS = "com.co.retrofit.artists"
        fun getPrefs(context: Context, name:String): SharedPreferences {
            return context.getSharedPreferences(name,
                Context.MODE_PRIVATE
            )
        }
    }
    private var albumsOfArtist: HashMap<Int, List<Album>> = hashMapOf()
    fun addAlbumsOfArtist(artistId: Int, albumOfArtist: List<Album>){
        if (!albumsOfArtist.containsKey(artistId)){
            albumsOfArtist[artistId] = albumOfArtist
        }
    }
    fun getAlbumsOfArtist(artistId: Int) : List<Album>{
        return if (albumsOfArtist.containsKey(artistId)) albumsOfArtist[artistId]!! else listOf<Album>()
    }

}