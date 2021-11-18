package com.co.retrofit.app.feature.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.network.NetworkServiceAdapter

class AlbumsOfArtistRepository (val application: Application) {
    suspend fun refreshData(artistId: Int):List<Album> {
        return NetworkServiceAdapter.getInstance(application).getAlbumsOfArtist(artistId)
    }


}