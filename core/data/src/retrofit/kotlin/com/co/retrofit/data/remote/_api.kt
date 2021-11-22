package com.co.retrofit.data.remote

import com.co.base.retrofit.backend.BackendClient
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.AlbumCreation
import com.co.retrofit.data.model.dto.DetailAlbum
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface Api {

    @GET("/albums")
    fun getAlbums(): Call<List<Album>>

    @GET("/albums/{id}")
    fun getDetailAlbum(@Path("id") id: Int): Call<DetailAlbum>

    @GET("/addAlbum")
    fun addAlbum(): Call<JsonElement>

    @PUT("/createAlbum")
    fun createAlbum(@Body albumCreation: AlbumCreation): Call<JsonElement>
}

val api: Api by lazy { BackendClient.api(Api::class.java) }