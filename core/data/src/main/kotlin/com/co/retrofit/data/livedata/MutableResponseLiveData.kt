package com.co.retrofit.data.livedata

import com.co.retrofit.data.model.DataResult
import com.co.retrofit.data.model.type.LOADING
import com.co.retrofit.data.model.type.SUCCESS

class MutableResponseLiveData<T> : ResponseLiveData<T>() {

    fun postLoading() {
        postValue(DataResult(null, null, LOADING))
    }

    fun postError(error: Throwable) {
        postValue(DataResult(null, error, com.co.retrofit.data.model.type.ERROR))
    }

    fun postData(data: T) {
        postValue(DataResult(data, null, SUCCESS))
    }
}