package com.co.retrofit.data.model.dto

import com.google.gson.annotations.SerializedName

class Album (
    @SerializedName("cover")
    val cover: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("genre")
    val genre: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("recordLabel")
    val recordLabel: String

)