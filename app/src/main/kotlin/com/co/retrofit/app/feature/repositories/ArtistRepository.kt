package com.co.retrofit.app.feature.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.network.NetworkServiceAdapter

class ArtistRepository (private val application: Application){
    fun refreshData(callback: (List<Artist>)->Unit, onError: (VolleyError)->Unit) {

        NetworkServiceAdapter.getInstance(application).getArtists({

            callback(it)
        },
            onError
        )
    }
}