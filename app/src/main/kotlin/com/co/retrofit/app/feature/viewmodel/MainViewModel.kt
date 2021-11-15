package com.co.retrofit.app.feature.viewmodel
import androidx.lifecycle.ViewModel
import com.co.retrofit.data.RepositoryProvider
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.Artist
import com.co.retrofit.data.model.dto.TestDto

class MainViewModel : ViewModel() {

    fun getAlbumsApi(): ResponseLiveData<List<Album>> {
         return RepositoryProvider.albumRepository.getAlbumsApi()
    }

    fun getArtistApi(): ResponseLiveData<List<Artist>> {
        return RepositoryProvider.artistRepository.getArtistApi()
    }

    fun getStateFloating(): ResponseLiveData<Boolean> {
        return RepositoryProvider.sessionRepository.getStateFloating()
    }

    fun setAlbumApi(albums: List<Album>): Unit {
        return RepositoryProvider.albumRepository.setAlbum(albums)
    }

    fun setArtist(artist: List<Artist>): Unit {
        return RepositoryProvider.artistRepository.setArtist(artist)
    }
}