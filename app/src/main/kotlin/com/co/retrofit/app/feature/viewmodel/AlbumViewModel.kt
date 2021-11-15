package com.co.retrofit.app.feature.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.RepositoryProvider
import com.co.retrofit.data.livedata.ResponseLiveData


class AlbumViewModel(application: Application) :  AndroidViewModel(application) {


    fun getAlbumCache(): ResponseLiveData<List<Album>> {
        return RepositoryProvider.albumRepository.getAlbums()
    }

    fun setStateFloating(state: Boolean) {
        return RepositoryProvider.sessionRepository.setStateFloating(state)
    }
}