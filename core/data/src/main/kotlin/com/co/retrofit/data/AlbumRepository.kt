package com.co.retrofit.data

import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.DetailAlbum
import com.co.retrofit.data.model.dto.TestDto

interface AlbumRepository {

    fun getAlbums(): ResponseLiveData<List<Album>> = throw NotImplementedError()

    fun getAlbumsApi(): ResponseLiveData<List<Album>> = throw NotImplementedError()

    fun getDetailAlbumApi(album: Album): ResponseLiveData<DetailAlbum> = throw NotImplementedError()

    fun saveSelectionAlbumItem(album: Album): Unit = throw NotImplementedError()

    fun setAlbum(albums: List<Album>): Unit = throw NotImplementedError()

    fun getAlbumSelectionMemory(): ResponseLiveData<Album> = throw NotImplementedError()
}