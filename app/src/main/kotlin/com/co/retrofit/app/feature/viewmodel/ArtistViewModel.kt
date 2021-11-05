package com.co.retrofit.app.feature.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.network.NetworkServiceAdapter
import com.co.retrofit.data.RepositoryProvider
import java.util.*

class ArtistViewModel(application: Application) : AndroidViewModel(application) {

    private val _artists = MutableLiveData<List<Artist>>()

    val artists: LiveData<List<Artist>>
        get() = _artists

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    init {
        refreshDataFromNetwork()
    }

    private fun refreshDataFromNetwork() {
        NetworkServiceAdapter.getInstance(getApplication()).getArtists({
            _artists.postValue(it)
            _eventNetworkError.value = false
            _isNetworkErrorShown.value = false
        },{
            _eventNetworkError.value = true
        })

        fun onNetworkErrorShown() {
            _isNetworkErrorShown.value = true
        }

        class Factory(val app: Application) : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(AlbumViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return ArtistViewModel(app) as T
                }
                throw IllegalArgumentException("Unable to construct viewmodel")
            }
        }
        fun setStateFloating(state: Boolean) {
            return RepositoryProvider.sessionRepository.setStateFloating(state)
        }
    }
}