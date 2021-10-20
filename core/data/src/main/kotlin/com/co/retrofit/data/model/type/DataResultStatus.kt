package com.co.retrofit.data.model.type

import androidx.annotation.IntDef

@IntDef(LOADING, SUCCESS, ERROR)
@Retention(AnnotationRetention.SOURCE)
annotation class DataResultStatus