package com.co.retrofit.data

import androidx.annotation.RestrictTo
import com.co.retrofit.data.livedata.MediatorResponseLiveData
import com.co.retrofit.data.livedata.MutableResponseLiveData
import com.co.retrofit.data.livedata.ResponseLiveData
import com.co.retrofit.data.model.dto.*
import com.co.retrofit.data.remote.api
import com.google.gson.JsonElement

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

    override fun setAlbum(albums: List<Album>): Unit {
        val liveData = MutableResponseLiveData<List<Album>>()
        liveData.postData(albums)
        this.albums.swapSource(liveData)
    }

    override fun getDetailAlbumApi(album: Album): ResponseLiveData<DetailAlbum> {
        // TODO: Se debe implementar el llamado del servicio por ahora se deja mockeado, dejar la linea que se tiene comentada 33 y quitar las de abajo
        return makeRequest(api.getDetailAlbum(album.id))
    }

    override fun addMusicAlbum(music: Music, id: Int): ResponseLiveData<JsonElement> {
        return makeRequest(api.addTrack(music, id))
    }

    override fun createAlbum(albumCreation: AlbumCreation): ResponseLiveData<JsonElement> {
        return makeRequest(api.createAlbum(albumCreation))
    }

    override fun saveSelectionAlbumItem(albumItems: Album): Unit {
        val liveData = MutableResponseLiveData<Album>()
        liveData.postData(albumItems)
        this.salectionAlbum.swapSource(liveData)
    }
}