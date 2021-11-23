package com.co.retrofit.data.remote

import com.co.base.retrofit.backend.BackendClient
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.AlbumCreation
import com.co.retrofit.data.model.dto.DetailAlbum
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET("/albums")
    fun getAlbums(): Call<List<Album>>

    @GET("/albums/{id}")
    fun getDetailAlbum(@Path("id") id: Int): Call<DetailAlbum>

    @GET("/addAlbum")
    fun addAlbum(): Call<JsonElement>

    @POST("/albums")
    fun createAlbum(@Body albumCreation: AlbumCreation): Call<JsonElement>
}

val api: Api by lazy { BackendClient.api(Api::class.java) }