package com.co.retrofit.data

import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.TestDto

interface SessionRepository {

    fun getExampleRequest(): ResponseLiveData<TestDto> = throw NotImplementedError()

}