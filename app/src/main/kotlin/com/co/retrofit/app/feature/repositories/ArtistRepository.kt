package com.co.retrofit.app.feature.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.network.NetworkServiceAdapter

class ArtistRepository (private val application: Application){
    suspend fun refreshData():List<Artist> {

        return NetworkServiceAdapter.getInstance(application).getArtists()
    }
}