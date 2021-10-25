package com.co.retrofit.data.model.dto

import com.google.gson.annotations.SerializedName

class TestDto {

    @SerializedName("results")
    var results: List<DataDTO> = arrayListOf()

}