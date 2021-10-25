package com.co.retrofit.data

import android.os.Handler
import android.os.Looper
import com.co.retrofit.data.livedata.MutableResponseLiveData
import com.co.retrofit.data.livedata.ResponseLiveData
import retrofit2.Call

fun async(block: () -> Unit) = Thread(block).apply { start() }

fun sync(block: () -> Unit) = Handler(Looper.getMainLooper()).post { block }

inline fun <T> makeRequest(call: Call<T>): ResponseLiveData<T> {
    val liveData = MutableResponseLiveData<T>()
        try {
            liveData.postLoading()
            var data = "" as T
            val thread = Thread(Runnable {
                data = call.execute().body()
            })
            thread.start()
            thread.join()
            liveData.postData(data)
        } catch (error: Exception) {
            val exception = when {
                else -> error
            }
            liveData.postError(exception)
        }
    return liveData
}