package com.co.retrofit.app.feature.model.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist(
    val artistId:Int,
    val name:String,
    val image:String,
    val creationDate:String,
    val description:String
):Parcelable
