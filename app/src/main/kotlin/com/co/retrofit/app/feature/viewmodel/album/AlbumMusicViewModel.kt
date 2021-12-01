package com.co.retrofit.app.feature.viewmodel.album

import android.app.Application
import androidx.lifecycle.*
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.RepositoryProvider
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Music
import com.google.gson.JsonElement


class AlbumMusicViewModel(application: Application) :  AndroidViewModel(application) {


    fun setStateFloating(state: Boolean) {
        return RepositoryProvider.sessionRepository.setStateFloating(state)
    }

    fun addMusic(music: Music, id: Int): ResponseLiveData<JsonElement> {
        return RepositoryProvider.albumRepository.addMusicAlbum(music, id)
    }

    fun getAlbumSelection(): ResponseLiveData<Album> {
        return RepositoryProvider.albumRepository.getAlbumSelectionMemory()
    }

}