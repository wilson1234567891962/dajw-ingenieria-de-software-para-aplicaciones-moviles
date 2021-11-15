package com.co.retrofit.data

import androidx.annotation.RestrictTo
import com.co.retrofit.data.livedata.MediatorResponseLiveData
import com.co.retrofit.data.livedata.MutableResponseLiveData
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.TestDto
import com.co.retrofit.data.remote.api

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal class SessionRepositoryImpl : SessionRepository {

    private var stateFloating = MediatorResponseLiveData<Boolean>()

    override fun getStateFloating(): ResponseLiveData<Boolean> {
        return this.stateFloating
    }

    override fun setStateFloating(state: Boolean) {
        val liveData = MutableResponseLiveData<Boolean>()
        liveData.postData(state)
        this.stateFloating.swapSource(liveData)
    }
}