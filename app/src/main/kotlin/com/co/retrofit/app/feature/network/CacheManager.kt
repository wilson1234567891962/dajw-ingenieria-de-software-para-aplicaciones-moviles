package com.co.retrofit.app.feature.network

import android.content.Context
import com.co.retrofit.app.feature.model.dto.Artist

class CacheManager(context: Context) {
    companion object{
        var instance: CacheManager? = null
        fun getInstance(context: Context)=
            instance?: synchronized(this){
                instance?: CacheManager(context).also{
                    instance = it
                }
            }
    }
    private var artistsHashMap: HashMap<Int, Artist> = hashMapOf()
    fun addArtists(artists: List<Artist>){
       for (artist in artists) {
           if (!artistsHashMap.containsKey(artist.artistId)) {
               artistsHashMap.put(artist.artistId, artist)
           }
       }
    }
    fun getArtists() : List<Artist>{
        return if (artistsHashMap.isNotEmpty()) ArrayList(artistsHashMap.values)!! else listOf<Artist>()
    }

}