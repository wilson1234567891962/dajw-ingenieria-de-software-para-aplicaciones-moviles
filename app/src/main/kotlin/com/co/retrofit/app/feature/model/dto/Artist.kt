package com.co.retrofit.app.feature.model.dto


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "artists_table")
data class Artist(
    @PrimaryKey val artistId:Int,
    val name:String,
    val image:String,
    val creationDate:String,
    val description:String
):Parcelable
