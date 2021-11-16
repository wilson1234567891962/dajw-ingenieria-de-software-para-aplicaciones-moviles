package com.co.retrofit.data

import android.os.Handler
import android.os.Looper
import com.co.retrofit.data.livedata.MutableResponseLiveData
import com.co.retrofit.data.livedata.ResponseLiveData
import retrofit2.Call
import retrofit2.Response

fun async(block: () -> Unit) = Thread(block).apply { start() }

fun sync(block: () -> Unit) = Handler(Looper.getMainLooper()).post { block }

inline fun <T> makeRequest(call: Call<T>): ResponseLiveData<T> {
    val liveData = MutableResponseLiveData<T>()
        try {
            liveData.postLoading()
            var response : Response<T> ? = null
            val thread = Thread(Runnable {
                response = call.execute()
            })
            thread.start()
            thread.join()

            response?.let {
                if(it.code() != 200) {
                    throw Exception(it.raw().message())
                }
                liveData.postData(it.body())
            }
        } catch (error: Exception) {
            val exception = when {
                else -> error
            }
            liveData.postError(exception)
        }
    return liveData
}