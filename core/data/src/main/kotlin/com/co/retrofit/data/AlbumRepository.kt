package com.co.retrofit.data

import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.*
import com.google.gson.JsonElement

interface AlbumRepository {

    fun getAlbums(): ResponseLiveData<List<Album>> = throw NotImplementedError()

    fun getAlbumsApi(): ResponseLiveData<List<Album>> = throw NotImplementedError()

    fun getDetailAlbumApi(album: Album): ResponseLiveData<DetailAlbum> = throw NotImplementedError()

    fun saveSelectionAlbumItem(album: Album): Unit = throw NotImplementedError()

    fun setAlbum(albums: List<Album>): Unit = throw NotImplementedError()

    fun addMusicAlbum(music: Music, id: Int): ResponseLiveData<JsonElement> = throw NotImplementedError()

    fun getAlbumSelectionMemory(): ResponseLiveData<Album> = throw NotImplementedError()

    fun createAlbum(albumCreation: AlbumCreation): ResponseLiveData<JsonElement>  = throw NotImplementedError()
}