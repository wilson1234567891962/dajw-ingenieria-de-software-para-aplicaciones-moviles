package com.co.retrofit.data.model.dto

import com.google.gson.annotations.SerializedName

class DetailAlbum (
    @SerializedName("title")
    val title: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("release")
    val release: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("genre")
    val genre: String,
    @SerializedName("recordLabel")
    val recordLabel: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("music")
    val music: List<MusicAlbum>
)