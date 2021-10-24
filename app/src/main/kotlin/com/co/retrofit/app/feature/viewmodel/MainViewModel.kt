package com.co.retrofit.app.feature.viewmodel
import androidx.lifecycle.ViewModel
import com.co.retrofit.data.RepositoryProvider
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.TestDto

class MainViewModel : ViewModel() {

    fun getExampleTest(): ResponseLiveData<TestDto> {
         return RepositoryProvider.sessionRepository.getExampleRequest()
    }

    fun getStateFloating(): ResponseLiveData<Boolean> {
        return RepositoryProvider.sessionRepository.getStateFloating()
    }
}