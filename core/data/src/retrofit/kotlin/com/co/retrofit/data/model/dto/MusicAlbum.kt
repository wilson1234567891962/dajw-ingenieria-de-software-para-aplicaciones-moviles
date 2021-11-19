package com.co.retrofit.data.model.dto

import com.google.gson.annotations.SerializedName

class MusicAlbum (
    @SerializedName("name")
    val name: String,
    @SerializedName("duration")
    val duration: String
)