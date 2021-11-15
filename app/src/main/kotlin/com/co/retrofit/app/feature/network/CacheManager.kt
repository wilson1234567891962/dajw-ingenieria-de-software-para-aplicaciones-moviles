package com.co.retrofit.app.feature.network

import android.content.Context
import android.content.SharedPreferences
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.model.dto.Collector

class CacheManager(context: Context) {
    companion object{
        var instance: CacheManager? = null
        fun getInstance(context: Context)=
            instance?: synchronized(this) {
                instance ?: CacheManager(context).also {
                    instance = it
                }
            }
        const val APP_SPREFS = "com.co.retrofit.app"
        const val ARTIST_SPREFS = "com.co.retrofit.artist"
        const val COLLECTOR_SPREFS = "com.co.retrofit.collector"

        fun getPrefs(context: Context, name:String): SharedPreferences {
            return context.getSharedPreferences(
                name,
                Context.MODE_PRIVATE
            )
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


    private var collectorsHashMap: HashMap<Int, Collector> = hashMapOf()
    fun addCollectors(collectors: List<Collector>){
        for (collector in collectors) {
            if (!collectorsHashMap.containsKey(collector.collectorId)) {
                collectorsHashMap.put(collector.collectorId, collector)
            }
        }
    }
    fun getCollectors() : List<Collector>{
        return if (collectorsHashMap.isNotEmpty()) ArrayList(collectorsHashMap.values)!! else listOf<Collector>()
    }




}