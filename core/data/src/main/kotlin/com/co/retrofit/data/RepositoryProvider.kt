package com.co.retrofit.data

object RepositoryProvider {

    val sessionRepository: SessionRepository by lazy(::SessionRepositoryImpl)

}