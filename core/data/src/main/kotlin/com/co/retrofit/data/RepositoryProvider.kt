package com.co.retrofit.data

object RepositoryProvider {

    val sessionRepository: SessionRepository by lazy(::SessionRepositoryImpl)
    val albumRepository: AlbumRepository by lazy(::AlbumRepositoryImpl)
    val artistRepository: ArtistRepository by lazy(::ArtistRepositoryImpl)
}