package com.co.retrofit.data.remote

import com.co.base.retrofit.backend.BackendClient
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.Artist
import com.co.retrofit.data.model.dto.DetailAlbum
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/albums")
    fun getAlbums(): Call<List<Album>>

    @GET("/bands")
    fun getArtist(): Call<List<Artist>>

    @GET("/albums/{id}")
    fun getDetailAlbum(@Path("id") id: Int): Call<DetailAlbum>

    @GET("/addAlbum")
    fun addAlbum(): Call<JsonElement>
}

val api: Api by lazy { BackendClient.api(Api::class.java) }