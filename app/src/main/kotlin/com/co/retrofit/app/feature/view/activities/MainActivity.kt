package com.co.retrofit.app.feature.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import com.co.base.retrofit.BaseActivity
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.base.retrofit.delegate.viewProvider
import com.co.base.retrofit.extension.hideLoader
import com.co.retrofit.app.R
import androidx.navigation.ui.setupWithNavController
import com.co.retrofit.app.feature.viewmodel.MainViewModel
import com.co.retrofit.data.model.dto.Album
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
            .observeErrorThrowable(this, ::observeErrorThrowable)
        btnFloating.setOnClickListener(this::addAlbum)
        getAlbumsApi()
    }

    @Suppress("UNUSED_PARAMETER")
    private fun observeErrorThrowable(error: Throwable){
        this.hideLoader()
        val intent = Intent(this, Maintenance::class.java)
        // start your next activity
        startActivity(intent)
    }

    private fun getAlbumsApi() {
        viewModel.getAlbumsApi()
            .observeData(this, ::getAlbums)
            .observeErrorThrowable(this, ::observeErrorThrowable)
    }



    private fun getAlbums(albums: List<Album>) {
        viewModel.setAlbumApi(albums)

    }



    @Suppress("UNUSED_PARAMETER")
    private fun addAlbum(view: View){
        val navController = findNavController(R.id.nav_host_fragment)

        if(navController.currentDestination?.id == R.id.navigation_detail_album){
            navController.navigate(R.id.navigation_add_music)
            return
        }
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