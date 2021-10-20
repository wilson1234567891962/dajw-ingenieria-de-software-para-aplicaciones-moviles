package com.co.retrofit.data.extention

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.co.retrofit.data.livedata.MediatorResponseLiveData
import com.co.retrofit.data.livedata.ResponseLiveData

fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T) -> Unit) = observe(owner, Observer { it?.let(observer) })

fun <T> LiveData<T>.observeSingle(owner: LifecycleOwner, observer: ((T) -> Unit)) = observeUntil(owner) {
    it.let(observer)
    true
}

fun <T> LiveData<T>.observeUntil(owner: LifecycleOwner, observer: ((T) -> Boolean)) {
    observe(owner, object : Observer<T> {
        override fun onChanged(data: T?) {
            if (data?.let(observer) == true) removeObserver(this)
        }
    })
}

fun <T, R> LiveData<T>.map(transformation: ((T) -> R)): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) {
        if (it == null) return@addSource
        result.setValue(it.let(transformation))
    }
    return result
}

fun <T, R> LiveData<List<T>>.mapList(transformation: ((T) -> R)): LiveData<List<R>> {
    val result = MediatorLiveData<List<R>>()
    result.addSource(this) {
        if (it == null) return@addSource
        result.setValue(it.map(transformation))
    }
    return result
}

fun <T, R> ResponseLiveData<List<T>>.mapList(transformation: ((T) -> R)): ResponseLiveData<List<R>> {
    val result = MediatorResponseLiveData<List<R>>()
    result.swapSource(this) {
        it.map(transformation)
    }
    return result
}
