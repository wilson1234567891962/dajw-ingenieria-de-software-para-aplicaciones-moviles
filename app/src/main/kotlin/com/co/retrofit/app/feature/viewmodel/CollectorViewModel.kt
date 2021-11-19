package com.co.retrofit.app.feature.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.co.retrofit.app.feature.database.dao.VinylRoomDatabase
import com.co.retrofit.app.feature.model.dto.Collector
import com.co.retrofit.app.feature.repositories.CollectorRepository
import com.co.retrofit.data.RepositoryProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CollectorViewModel(application: Application)  :  AndroidViewModel(application) {

    private val collectorRepository = CollectorRepository(application, VinylRoomDatabase.getDatabase(application.applicationContext).collectorsDao())

    private val _collectors = MutableLiveData<List<Collector>>()

    val collectors: LiveData<List<Collector>>
        get() = _collectors

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
        try{
            viewModelScope.launch (Dispatchers.Default) {
                withContext(Dispatchers.IO) {
                    var data = collectorRepository.refreshData()
                    _collectors.postValue(data)
                }
                _eventNetworkError.postValue(false)
                _isNetworkErrorShown.postValue(false)
            }
        }
        catch (e:Exception){
            Log.d("Error", e.toString())
            _eventNetworkError.value = true
        }
    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CollectorViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CollectorViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
    fun setStateFloating(state: Boolean) {
        return RepositoryProvider.sessionRepository.setStateFloating(state)
    }
}