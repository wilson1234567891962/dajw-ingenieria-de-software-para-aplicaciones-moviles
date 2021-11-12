package com.co.retrofit.app.feature.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    val artistId:Int,
    val name:String,
    val image:String,
    val creationDate:String,
    val description:String
)
