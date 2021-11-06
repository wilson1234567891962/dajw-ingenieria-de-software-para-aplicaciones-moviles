package com.co.retrofit.data.remote

import com.co.base.retrofit.backend.BackendClient
import com.co.retrofit.data.model.dto.TestDto
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/api/character/?page=1")
    fun getExampleTest(): Call<TestDto>
}

val api: Api by lazy { BackendClient.api(Api::class.java) }