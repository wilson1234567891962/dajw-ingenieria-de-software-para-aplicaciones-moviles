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

    private var album = MediatorResponseLiveData<Album>()

    override fun saveAlbumSelection(album: Album) {
        val liveData = MutableResponseLiveData<Album>()
        liveData.postData(album)
        this.album.swapSource(liveData)
    }

    override fun getAlbumSelection(): ResponseLiveData<Album> {
        return album
    }
}