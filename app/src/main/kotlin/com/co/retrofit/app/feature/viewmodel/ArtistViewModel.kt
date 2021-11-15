package com.co.retrofit.app.feature.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.co.retrofit.data.RepositoryProvider
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Artist


class ArtistViewModel(application: Application) :  AndroidViewModel(application) {

    fun getArtistCache(): ResponseLiveData<List<Artist>> {
        return RepositoryProvider.artistRepository.getArtist()
    }

    fun setStateFloating(state: Boolean) {
        return RepositoryProvider.sessionRepository.setStateFloating(state)
    }
}