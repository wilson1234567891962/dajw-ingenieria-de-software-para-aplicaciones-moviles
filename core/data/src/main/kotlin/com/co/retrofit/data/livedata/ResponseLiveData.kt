package com.co.retrofit.data.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.co.retrofit.data.model.DataResult
import com.co.retrofit.data.extention.observeUntil
import com.co.retrofit.data.model.type.ERROR
import com.co.retrofit.data.model.type.LOADING
import com.co.retrofit.data.model.type.SUCCESS

open class ResponseLiveData<T> : LiveData<DataResult<T>>() {

    fun observeShowLoading(owner: LifecycleOwner, observer: () -> Unit): ResponseLiveData<T> {
        observe(owner, Observer {
            if (it?.status == LOADING) observer.invoke()
        })
        return this
    }

    fun observeHideLoading(owner: LifecycleOwner, observer: () -> Unit): ResponseLiveData<T> {
        observe(owner, Observer {
            if (it?.status != LOADING) observer.invoke()
        })
        return this
    }

    fun observeErrorThrowable(owner: LifecycleOwner, observer: (Throwable) -> Unit): ResponseLiveData<T> {
        observe(owner, Observer {
            if (it?.status == ERROR) it.error?.apply(observer)
        })
        return this
    }

    fun observeError(owner: LifecycleOwner, observer: () -> Unit): ResponseLiveData<T> {
        observe(owner, Observer {
            if (it?.status == ERROR) observer.invoke()
        })
        return this
    }

    fun observeData(owner: LifecycleOwner, observer: (T) -> Unit): ResponseLiveData<T> {
        observe(owner, Observer {
            it?.data?.apply(observer)
        })
        return this
    }

    fun observeSuccess(owner: LifecycleOwner, observer: () -> Unit): ResponseLiveData<T> {
        observe(owner, Observer {
            if (it?.status == SUCCESS) observer.invoke()
        })
        return this
    }

    fun observeSingleShowLoading(owner: LifecycleOwner, observer: () -> Unit): ResponseLiveData<T> {
        observeUntil(owner) {
            if (it.status == LOADING) observer.invoke()
            it.status == LOADING
        }
        return this
    }

    fun observeSingleHideLoading(owner: LifecycleOwner, observer: () -> Unit): ResponseLiveData<T> {
        observeUntil(owner) {
            if (it.status != LOADING) observer.invoke()
            it.status != LOADING
        }
        return this
    }

    fun observeSingleError(owner: LifecycleOwner, observer: (Throwable) -> Unit): ResponseLiveData<T> {
        observeUntil(owner) {
            if (it.status == ERROR) it.error?.apply(observer)
            it.status == ERROR && it.error != null
        }
        return this
    }

    fun observeSingleError(owner: LifecycleOwner, observer: () -> Unit): ResponseLiveData<T> {
        observeUntil(owner) {
            if (it.status == ERROR) observer.invoke()
            it.status == ERROR
        }
        return this
    }

    fun observeSingleData(owner: LifecycleOwner, observer: (T) -> Unit): ResponseLiveData<T> {
        observeUntil(owner) {
            it.data?.apply(observer)
            it.data != null
        }
        return this
    }

    fun observeSingleSuccess(owner: LifecycleOwner, observer: () -> Unit): ResponseLiveData<T> {
        observeUntil(owner) {
            if (it.status == SUCCESS) observer.invoke()
            it.status == SUCCESS
        }
        return this
    }

    val error: Throwable?
        get() = value?.error

    val status: Int?
        get() = value?.status

    val data: T?
        get() = value?.data

    fun <R> map(transformation: ((T) -> R)): ResponseLiveData<R> {
        val liveData = MediatorResponseLiveData<R>()
        liveData.swapSource(this, transformation)
        return liveData
    }

    fun onNext(onNext: ((T) -> Unit)): ResponseLiveData<T> {
        return map {
            onNext(it)
            it
        }
    }
}