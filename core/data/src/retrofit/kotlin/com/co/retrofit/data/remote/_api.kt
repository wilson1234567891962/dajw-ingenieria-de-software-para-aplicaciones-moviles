package com.co.retrofit.data.remote

import com.co.base.retrofit.backend.BackendClient
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.Artist
import com.co.retrofit.data.model.dto.DetailAlbum
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/albums")
    fun getAlbums(): Call<List<Album>>

    @GET("/bands")
    fun getArtist(): Call<List<Artist>>

    @GET("/detail")
    fun getDetailAlbum(): Call<DetailAlbum>

    @GET("/addAlbum")
    fun addAlbum(): Call<JsonElement>
}

val api: Api by lazy { BackendClient.api(Api::class.java) }