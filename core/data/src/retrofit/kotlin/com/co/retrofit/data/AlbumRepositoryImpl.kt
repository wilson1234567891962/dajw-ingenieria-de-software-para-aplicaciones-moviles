package com.co.retrofit.data

import androidx.annotation.RestrictTo
import com.co.retrofit.data.livedata.MediatorResponseLiveData
import com.co.retrofit.data.livedata.MutableResponseLiveData
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.TestDto
import com.co.retrofit.data.remote.api

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal class AlbumRepositoryImpl : AlbumRepository {

    private var albums = MediatorResponseLiveData<List<Album>>()


    override fun getAlbums(): ResponseLiveData<List<Album>> {
        return this.albums
    }

    override fun getAlbumsApi(): ResponseLiveData<List<Album>> {
        return makeRequest(api.getAlbums())
    }

    override fun setAlbum(albums: List<Album>): Unit {
        val liveData = MutableResponseLiveData<List<Album>>()
        liveData.postData(albums)
        this.albums.swapSource(liveData)
    }
}