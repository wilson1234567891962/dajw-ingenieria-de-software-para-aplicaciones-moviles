package com.co.retrofit.data.model

import com.co.retrofit.data.model.type.DataResultStatus

class DataResult<out T>(
    val data: T?,
    val error: Throwable?,
    @get:DataResultStatus
    @DataResultStatus val status: Int
)