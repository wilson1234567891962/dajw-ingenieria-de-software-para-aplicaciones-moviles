package com.co.retrofit.data.model.dto

import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("id")
    val artistId:Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("image")
    val image:String,
    @SerializedName("creationDate")
    val creationDate:String,
    @SerializedName("description")
    val description:String
)
