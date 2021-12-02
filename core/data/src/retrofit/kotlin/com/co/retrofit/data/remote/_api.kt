package com.co.retrofit.data.remote

import com.co.base.retrofit.backend.BackendClient
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.AlbumCreation
import com.co.retrofit.data.model.dto.DetailAlbum
import com.co.retrofit.data.model.dto.Music
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET("/albums")
    fun getAlbums(): Call<List<Album>>

    @GET("/albums/{id}")
    fun getDetailAlbum(@Path("id") id: Int): Call<DetailAlbum>

    @POST("/albums/{id}/tracks")
    fun addTrack(@Body music: Music, @Path("id") id: Int ): Call<JsonElement>

    @POST("/albums")
    fun createAlbum(@Body albumCreation: AlbumCreation): Call<JsonElement>
}

val api: Api by lazy { BackendClient.api(Api::class.java) }