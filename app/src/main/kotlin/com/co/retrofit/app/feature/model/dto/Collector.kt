package com.co.retrofit.app.feature.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class Collector (
    val collectorId: Int,
    val name:String,
    val telephone:String,
    val email:String
)