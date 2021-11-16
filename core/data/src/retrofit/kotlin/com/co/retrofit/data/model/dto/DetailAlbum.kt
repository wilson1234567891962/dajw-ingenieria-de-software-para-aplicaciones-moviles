package com.co.retrofit.data.model.dto

import com.google.gson.annotations.SerializedName

class DetailAlbum (
    @SerializedName("name")
    val title: String,
    @SerializedName("performers")
    val name: List<Performer>,
    @SerializedName("releaseDate")
    val release: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("genre")
    val genre: String,
    @SerializedName("recordLabel")
    val recordLabel: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("tracks")
    val music: List<MusicAlbum>
)