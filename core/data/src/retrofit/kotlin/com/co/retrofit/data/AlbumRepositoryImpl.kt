package com.co.retrofit.data

import androidx.annotation.RestrictTo
import com.co.retrofit.data.livedata.MediatorResponseLiveData
import com.co.retrofit.data.livedata.MutableResponseLiveData
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.DetailAlbum
import com.co.retrofit.data.model.dto.MusicAlbum
import com.co.retrofit.data.model.dto.TestDto
import com.co.retrofit.data.remote.api

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal class AlbumRepositoryImpl : AlbumRepository {

    private var albums = MediatorResponseLiveData<List<Album>>()
    private var salectionAlbum = MediatorResponseLiveData<Album>()
    private var detailAlbum = MediatorResponseLiveData<DetailAlbum>()

    override fun getAlbums(): ResponseLiveData<List<Album>> {
        return this.albums
    }


    override fun getAlbumSelectionMemory(): ResponseLiveData<Album> {
        return this.salectionAlbum
    }

    override fun getAlbumsApi(): ResponseLiveData<List<Album>> {
        return makeRequest(api.getAlbums())
    }

    override fun getDetailAlbumApi(album: Album): ResponseLiveData<DetailAlbum> {
        // TODO: Se debe implementar el llamado del servicio por ahora se deja mockeado, dejar la linea que se tiene comentada 33 y quitar las de abajo
        // return makeRequest(api.getDetailAlbum())
        val liveData = MutableResponseLiveData<DetailAlbum>()
        liveData.postData(DetailAlbum("Amor   Clandestino","Mana", "2011","https://i.pinimg.com/564x/aa/5f/ed/aa5fed7fac61cc8f41d1e79db917a7cd.jpg", "Rock", "Sony Music",
            "Maná es una banda de rock pop mexicana aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa  aaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaa", arrayOf(MusicAlbum(" Mariposa Traicionera", "4:40"))))
        this.detailAlbum.swapSource(liveData)
        return this.detailAlbum
    }

    override fun setAlbum(albums: List<Album>): Unit {
        val liveData = MutableResponseLiveData<List<Album>>()
        liveData.postData(albums)
        this.albums.swapSource(liveData)
    }

    override fun saveSelectionAlbumItem(albums: Album): Unit {
        val liveData = MutableResponseLiveData<Album>()
        liveData.postData(albums)
        this.salectionAlbum.swapSource(liveData)
    }
}