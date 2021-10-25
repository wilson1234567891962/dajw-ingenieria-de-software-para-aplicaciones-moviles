package com.co.retrofit.data.livedata

import androidx.lifecycle.MediatorLiveData
import com.co.retrofit.data.async
import com.co.retrofit.data.model.DataResult
import com.co.retrofit.data.model.type.ERROR
import com.co.retrofit.data.model.type.LOADING
import com.co.retrofit.data.model.type.SUCCESS
import com.co.retrofit.data.sync

class MediatorResponseLiveData<T> : ResponseLiveData<T>() {

    private val sourceLiveData = MediatorLiveData<Any>()
    private val sourceObserver: (Any?) -> Unit = {}
    private var lastSource: ResponseLiveData<*>? = null

    val hasDataSource: Boolean
        get() = lastSource != null

    fun swapSource(source: ResponseLiveData<T>, discardAfterLoading: Boolean = false) {
        clearSource()
        sourceLiveData.addSource(source) {
            value = it
            if (it?.status != LOADING && discardAfterLoading) value = null
        }
        lastSource = source
    }

    fun <R> swapSource(source: ResponseLiveData<R>, transformation: (R) -> T) {
        clearSource()
        sourceLiveData.addSource(source) { data ->
            async {
                if (data == null) return@async
                val newValue = when (data.status) {
                    SUCCESS -> DataResult(data.data?.let(transformation), null, SUCCESS)
                    ERROR -> DataResult(value?.data, data.error, ERROR)
                    LOADING -> DataResult(value?.data, null, LOADING)
                    else -> null
                }
                if (value != newValue) postValue(newValue)
            }
        }
        lastSource = source
    }

    fun clear() {
        clearSource()
        value = null
    }

    override fun onActive() {
        super.onActive()
        if (!sourceLiveData.hasObservers()) sourceLiveData.observeForever(sourceObserver)
    }

    override fun onInactive() {
        super.onInactive()
        sourceLiveData.removeObserver(sourceObserver)
    }

    private fun clearSource() {
        sync {
            lastSource?.let { sourceLiveData.removeSource(it) }
            lastSource = null
        }
    }
}