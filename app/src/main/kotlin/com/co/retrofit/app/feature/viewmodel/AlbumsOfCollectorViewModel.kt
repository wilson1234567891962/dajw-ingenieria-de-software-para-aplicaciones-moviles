package com.co.retrofit.app.feature.viewmodel

import android.app.Application
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.co.retrofit.app.databinding.FragmentAlbumsOfArtistBinding
import com.co.retrofit.app.feature.database.dao.VinylRoomDatabase
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.model.dto.Collector
import com.co.retrofit.app.feature.repositories.AlbumsOfArtistRepository
import com.co.retrofit.app.feature.repositories.AlbumsOfCollectorRepository
import com.co.retrofit.app.feature.view.adapter.AlbumOfArtistAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlbumsOfCollectorViewModel (application: Application, collectorId: Int, collector: Collector) :  AndroidViewModel(application){

    private val albumsOfCollectorRepository = AlbumsOfCollectorRepository(application, VinylRoomDatabase.getDatabase(application.applicationContext).albumsOfCollectorDao())

    private val _albumsOfCollector = MutableLiveData<List<Album>>()

    val albumsOfCollector: LiveData<List<Album>>
        get() = _albumsOfCollector

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    val id:Int = collectorId
    var collector :Collector = collector
        set(value) {
            field = value
        }


    init {
        refreshDataFromNetwork()

    }

    private fun refreshDataFromNetwork() {
        try {
            viewModelScope.launch (Dispatchers.Default){
                withContext(Dispatchers.IO){
                    var data = albumsOfCollectorRepository.refreshData(id)
                    _albumsOfCollector.postValue(data)
                }
                _eventNetworkError.postValue(false)
                _isNetworkErrorShown.postValue(false)
            }
        }
        catch (e:Exception){
            _eventNetworkError.value = true
        }
    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    class Factory(val app: Application, val collectorId: Int, val collector: Collector) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlbumsOfCollectorViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AlbumsOfCollectorViewModel(app, collectorId, collector) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}