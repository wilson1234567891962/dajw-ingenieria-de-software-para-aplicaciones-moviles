package com.co.retrofit.app.feature.viewmodel
import androidx.lifecycle.ViewModel
import com.co.retrofit.data.RepositoryProvider
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album

class MainViewModel : ViewModel() {

    fun getAlbumsApi(): ResponseLiveData<List<Album>> {
         return RepositoryProvider.albumRepository.getAlbumsApi()
    }


    fun getStateFloating(): ResponseLiveData<Boolean> {
        return RepositoryProvider.sessionRepository.getStateFloating()
    }

    fun setAlbumApi(albums: List<Album>) {
        return RepositoryProvider.albumRepository.setAlbum(albums)
    }


}