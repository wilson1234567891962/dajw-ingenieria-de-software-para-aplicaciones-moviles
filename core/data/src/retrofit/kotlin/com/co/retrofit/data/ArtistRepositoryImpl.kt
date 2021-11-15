package com.co.retrofit.data

import androidx.annotation.RestrictTo
import com.co.retrofit.data.livedata.MediatorResponseLiveData
import com.co.retrofit.data.livedata.MutableResponseLiveData
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.Artist
import com.co.retrofit.data.model.dto.TestDto
import com.co.retrofit.data.remote.api

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal class ArtistRepositoryImpl : ArtistRepository {

    private var artist = MediatorResponseLiveData<List<Artist>>()


    override fun getArtist(): ResponseLiveData<List<Artist>> {
        return this.artist
    }

    override fun getArtistApi(): ResponseLiveData<List<Artist>> {
        return makeRequest(api.getArtist())
    }

    override fun setArtist(albums: List<Artist>): Unit {
        val liveData = MutableResponseLiveData<List<Artist>>()
        liveData.postData(albums)
        this.artist.swapSource(liveData)
    }
}