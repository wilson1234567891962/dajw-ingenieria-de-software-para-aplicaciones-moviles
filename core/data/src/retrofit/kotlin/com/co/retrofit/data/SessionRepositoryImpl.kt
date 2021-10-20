package com.co.retrofit.data

import androidx.annotation.RestrictTo
import com.co.retrofit.data.livedata.MediatorResponseLiveData
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.TestDto
import com.co.retrofit.data.remote.api

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal class SessionRepositoryImpl : SessionRepository {

    override fun getExampleRequest(): ResponseLiveData<TestDto> {
        return makeRequest(api.getExampleTest())
    }
}