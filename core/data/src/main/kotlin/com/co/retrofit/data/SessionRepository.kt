package com.co.retrofit.data

import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.TestDto

interface SessionRepository {

    fun getStateFloating(): ResponseLiveData<Boolean> = throw NotImplementedError()
    fun setStateFloating(state: Boolean): Unit = throw NotImplementedError()
}