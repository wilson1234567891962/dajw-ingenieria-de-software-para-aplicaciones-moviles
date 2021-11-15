package com.co.retrofit.data.remote

import com.co.base.retrofit.backend.BackendClient
import com.co.retrofit.data.model.dto.Album
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/albums")
    fun getAlbums(): Call<List<Album>>
}

val api: Api by lazy { BackendClient.api(Api::class.java) }