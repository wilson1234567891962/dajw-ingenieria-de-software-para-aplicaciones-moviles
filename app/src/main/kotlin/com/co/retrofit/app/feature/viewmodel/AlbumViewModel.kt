package com.co.retrofit.app.feature.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.repositories.AlbumRepository
import com.co.retrofit.data.RepositoryProvider


class AlbumViewModel(application: Application) :  AndroidViewModel(application) {

    private val albumRepository = AlbumRepository(application)

    private val _albums = MutableLiveData<List<Album>>()

    val albums: LiveData<List<Album>>
        get() = _albums

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown


    fun refreshDataFromNetwork() {
        albumRepository.refreshData({
            _albums.postValue(it)
            _eventNetworkError.value = false
            _isNetworkErrorShown.value = false
        },{
            _eventNetworkError.value = true
        })
    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlbumViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AlbumViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
    fun setStateFloating(state: Boolean) {
        return RepositoryProvider.sessionRepository.setStateFloating(state)
    }
}