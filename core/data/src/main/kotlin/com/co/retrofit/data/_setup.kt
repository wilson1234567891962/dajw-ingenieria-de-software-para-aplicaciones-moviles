package com.co.retrofit.data

import android.app.Application
import com.co.base.retrofit.backend.BackendClient

fun Application.setupBackend() {

        BackendClient.initClient()
}
