package com.co.retrofit.data

import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.Artist
import com.co.retrofit.data.model.dto.TestDto

interface ArtistRepository {

    fun getArtist(): ResponseLiveData<List<Artist>> = throw NotImplementedError()

    fun getArtistApi(): ResponseLiveData<List<Artist>> = throw NotImplementedError()

    fun setArtist(albums: List<Artist>): Unit = throw NotImplementedError()
}