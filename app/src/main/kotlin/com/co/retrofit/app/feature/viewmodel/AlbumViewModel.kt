package com.co.retrofit.app.feature.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.co.retrofit.data.RepositoryProvider
import com.co.retrofit.data.livedata.ResponseLiveData

class AlbumViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun setStateFloating(state: Boolean) {
        return RepositoryProvider.sessionRepository.setStateFloating(state)
    }
}