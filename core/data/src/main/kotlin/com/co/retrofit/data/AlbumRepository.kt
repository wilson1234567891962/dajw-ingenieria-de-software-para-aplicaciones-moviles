package com.co.retrofit.data
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album

interface AlbumRepository {

    fun saveAlbumSelection(album: Album): Unit = throw NotImplementedError()

    fun getAlbumSelection(): ResponseLiveData<Album> = throw NotImplementedError()
}