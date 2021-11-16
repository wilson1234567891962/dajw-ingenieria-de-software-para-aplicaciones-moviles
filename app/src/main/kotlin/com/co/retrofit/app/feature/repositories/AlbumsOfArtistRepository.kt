package com.co.retrofit.app.feature.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.network.NetworkServiceAdapter

class AlbumsOfArtistRepository (val application: Application) {
    fun refreshData(artistId: Int, callback: (List<Album>)->Unit, onError: (VolleyError)->Unit) {
        //Determinar la fuente de datos que se va a utilizar. Si es necesario consultar la red, ejecutar el siguiente código
        NetworkServiceAdapter.getInstance(application).getAlbumsOfArtist(artistId,{
            //Guardar los coleccionistas de la variable it en un almacén de datos local para uso futuro
            callback(it)
        },
            onError
        )
    }


}