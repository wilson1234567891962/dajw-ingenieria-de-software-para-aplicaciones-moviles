package com.co.retrofit.app.feature.viewmodel.album

import android.app.Application
import androidx.lifecycle.*
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.RepositoryProvider
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.DetailAlbum


class AlbumDetailViewModel(application: Application) :  AndroidViewModel(application) {


    fun getAlbumSelection(): ResponseLiveData<Album> {
        return RepositoryProvider.albumRepository.getAlbumSelectionMemory()
    }

    fun getAlbumDetailApi(album: Album): ResponseLiveData<DetailAlbum> {
        return RepositoryProvider.albumRepository.getDetailAlbumApi(album)
    }

    fun setStateFloating(state: Boolean) {
        return RepositoryProvider.sessionRepository.setStateFloating(state)
    }
}