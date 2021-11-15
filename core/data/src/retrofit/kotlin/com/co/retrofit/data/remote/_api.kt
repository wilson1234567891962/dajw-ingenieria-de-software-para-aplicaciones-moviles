package com.co.retrofit.data.remote

import com.co.base.retrofit.backend.BackendClient
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.Artist
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/albums")
    fun getAlbums(): Call<List<Album>>

    @GET("/bands")
    fun getArtist(): Call<List<Artist>>
}

val api: Api by lazy { BackendClient.api(Api::class.java) }