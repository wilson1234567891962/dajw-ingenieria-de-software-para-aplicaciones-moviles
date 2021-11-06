package com.co.retrofit.app.feature.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.network.NetworkServiceAdapter

class AlbumRepository (private val application: Application){
    fun refreshData(callback: (List<Album>)->Unit, onError: (VolleyError)->Unit) {

        NetworkServiceAdapter.getInstance(application).getAlbums({

            callback(it)
        },
            onError
        )
    }
}