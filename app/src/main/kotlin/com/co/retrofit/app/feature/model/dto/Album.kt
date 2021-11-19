package com.co.retrofit.app.feature.model.dto

import kotlinx.serialization.Serializable
import org.json.JSONArray

@Serializable
data class Album (
    val cover: String,
    val name: String,
    val genre: String
)