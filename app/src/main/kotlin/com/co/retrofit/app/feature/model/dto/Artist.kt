package com.co.retrofit.app.feature.model.dto


import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
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
