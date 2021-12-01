package com.co.retrofit.app.feature.model.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "collectors_table")
data class Collector (
    @PrimaryKey val collectorId: Int,
    val name:String,
    val telephone:String,
    val email:String
): Parcelable