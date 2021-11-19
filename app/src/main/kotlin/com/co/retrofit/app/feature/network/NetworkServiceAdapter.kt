package com.co.retrofit.app.feature.network

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.model.dto.Collector
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import org.json.JSONArray
import org.json.JSONObject
import java.util.stream.Collectors


class NetworkServiceAdapter constructor(context: Context) {
    companion object{
        const val BASE_URL= "https://vinilosg1.herokuapp.com/"
        var instance: NetworkServiceAdapter? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: NetworkServiceAdapter(context).also {
                    instance = it
                }
            }
    }
    private val requestQueue: RequestQueue by lazy {
        // applicationContext keeps you from leaking the Activity or BroadcastReceiver if someone passes one in.
        Volley.newRequestQueue(context.applicationContext)
    }
    suspend fun getArtists() =  suspendCoroutine<List<Artist>>{ cont->
        requestQueue.add(getRequest("bands",
            Response.Listener<String> { response ->
                val resp = JSONArray(response)
                val list = mutableListOf<Artist>()
                var item: JSONObject? = null
                for (i in 0 until resp.length()) {
                    item = resp.getJSONObject(i)
                    list.add(i, Artist(
                            artistId = item.getInt("id"),
                            name = item.getString("name"),
                            image = item.getString("image"),
                            creationDate = item.getString("creationDate"),
                            description = item.getString("description")))
                }
                cont.resume(list)
            },
            Response.ErrorListener {
                cont.resumeWithException (it)
            }))
    }
    suspend fun getCollectors() =  suspendCoroutine<List<Collector>>{ cont->
        requestQueue.add(getRequest("collectors",
            Response.Listener<String> { response ->
                val resp = JSONArray(response)
                val list = mutableListOf<Collector>()
                var item: JSONObject? = null
                for (i in 0 until resp.length()) {
                    item = resp.getJSONObject(i)
                    list.add(i, Collector(
                        collectorId = item.getInt("id"),
                        name = item.getString("name"),
                        telephone = item.getString("telephone"),
                        email = item.getString("email")))
                }
                cont.resume(list)
            },
            Response.ErrorListener {
                cont.resumeWithException (it)
            }))
    }

    fun getAlbums(onComplete:(resp:List<Album>)->Unit, onError: (error:VolleyError)->Unit){
        requestQueue.add(getRequest("albums",
            Response.Listener<String> { response ->
                val resp = JSONArray(response)
                val list = mutableListOf<Album>()
                for (i in 0 until resp.length()) {
                    val item = resp.getJSONObject(i)
                    list.add(i, Album(name = item.getString("name"), cover = item.getString("cover"), genre = item.getString("genre")))
                }
                onComplete(list)
            },
            Response.ErrorListener {
                onError(it)
            }))
    }


    private fun getRequest(path:String, responseListener: Response.Listener<String>, errorListener: Response.ErrorListener): StringRequest {
        return StringRequest(Request.Method.GET, BASE_URL+path, responseListener,errorListener)
    }

}