package com.co.retrofit.app.feature.viewmodel.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.co.retrofit.data.RepositoryProvider
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.AlbumCreation

import com.google.gson.JsonElement

class AlbumCreationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun setStateFloating(state: Boolean) {
        return RepositoryProvider.sessionRepository.setStateFloating(state)
    }

    fun createAlbum(album: AlbumCreation): ResponseLiveData<JsonElement> {
        return RepositoryProvider.albumRepository.createAlbum(album)
    }

    fun getAlbumsApi(): ResponseLiveData<List<Album>> {
        return RepositoryProvider.albumRepository.getAlbumsApi()
    }

    fun setAlbumApi(albums: List<Album>) {
        return RepositoryProvider.albumRepository.setAlbum(albums)
    }
}