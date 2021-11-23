package com.co.retrofit.app.feature.model.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import org.json.JSONArray

@Serializable
@Entity(tableName = "albums_table")
data class Album (
    val cover: String,
    val name: String,
    val genre: String,
    @PrimaryKey(autoGenerate = true)
    val artistId:Int = 0,
    val collectorId:Int = 0
)