package com.co.retrofit.app.feature.view.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import com.co.base.retrofit.BaseActivity
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.base.retrofit.delegate.viewProvider
import com.co.base.retrofit.extension.hideLoader
import com.co.base.retrofit.extension.showLoader
import com.co.retrofit.app.R
import com.co.retrofit.data.model.dto.TestDto
import androidx.navigation.ui.setupWithNavController
import com.co.retrofit.app.feature.viewmodel.MainViewModel
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.Artist
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : BaseActivity() {

    private val viewModel by viewModelProvider(MainViewModel::class)
    private lateinit var bottomNavigationView: BottomNavigationView
    private val btnFloating: FloatingActionButton by viewProvider(R.id.fab)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navController = findNavController(R.id.nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)
        this.setUpListenerEvent()
    }

    private fun setUpListenerEvent() {
        viewModel.getStateFloating()
            .observeData(this, ::getStateFloating)
            .observeError(this, ::observeErrorThrowable)
            .observeErrorThrowable(this, ::observeErrorThrowable)
        btnFloating.setOnClickListener(this::addAlbum)
        getAlbumsApi()
        getArtistApi()
    }

    private fun observeErrorThrowable(){
        Log.d("Fue resultado exitoso", "")
    }

    private fun observeErrorThrowable(error: Throwable){
        Log.d("Fue resultado exitoso", error.toString())
    }

    private fun getAlbumsApi() {
        viewModel.getAlbumsApi()
            .observeData(this, ::getAlbums)
            .observeShowLoading(this, ::showLoader)
            .observeHideLoading(this, ::hideLoader)
            .observeError(this, ::observeErrorThrowable)
            .observeErrorThrowable(this, ::observeErrorThrowable)
    }

    private fun getArtistApi() {
        viewModel.getArtistApi()
            .observeData(this, ::getArtist)
            .observeShowLoading(this, ::showLoader)
            .observeHideLoading(this, ::hideLoader)
            .observeError(this, ::observeErrorThrowable)
            .observeErrorThrowable(this, ::observeErrorThrowable)
    }

    private fun getAlbums(albums: List<Album>) {
        viewModel.setAlbumApi(albums)
    }

    private fun getArtist(artist: List<Artist>) {
        viewModel.setArtist(artist)
    }

    private fun addAlbum(view: View){
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.fragment_album_creation)
    }

    private fun getStateFloating(state: Boolean) {
        if(state) {
            btnFloating.show()
        }else {
            btnFloating.hide()
        }
    }
}
