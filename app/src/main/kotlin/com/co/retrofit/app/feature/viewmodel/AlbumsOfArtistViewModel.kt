package com.co.retrofit.app.feature.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.repositories.AlbumsOfArtistRepository
import com.co.retrofit.app.feature.view.adapter.AlbumOfArtistAdapter

class AlbumsOfArtistViewModel (application: Application, artistId: Int, artist: Artist) :  AndroidViewModel(application){

    private val albumsOfArtistRepository = AlbumsOfArtistRepository(application)

    private val _albumsOfArtist = MutableLiveData<List<Album>>()

    val albumsOfArtist: LiveData<List<Album>>
        get() = _albumsOfArtist

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    val id:Int = artistId
    var artist :Artist = artist
        set(value) {
            field = value
        }


    init {
        refreshDataFromNetwork()
    }


    private fun refreshDataFromNetwork() {
        albumsOfArtistRepository.refreshData(id, {
            _albumsOfArtist.postValue(it)
            _eventNetworkError.value = false
            _isNetworkErrorShown.value = false
        },{
            Log.d("Error", it.toString())
            _eventNetworkError.value = true
        })
    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    class Factory(val app: Application, val artistId: Int, val artist: Artist) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlbumsOfArtistViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AlbumsOfArtistViewModel(app, artistId, artist) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}