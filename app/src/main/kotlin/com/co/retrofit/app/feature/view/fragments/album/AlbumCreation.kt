package com.co.retrofit.app.feature.view.fragments.album

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.base.retrofit.delegate.viewProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentAlbumCreationBinding
import com.co.retrofit.app.feature.view.activities.Maintenance
import com.co.retrofit.app.feature.viewmodel.album.AlbumCreationViewModel
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.AlbumCreation
import com.google.gson.JsonElement


class AlbumCreation: Fragment() {

    private val albumCreationViewModel by viewModelProvider(AlbumCreationViewModel::class)
    private var mBinding: FragmentAlbumCreationBinding? = null
    private val arrowBack: ImageView by viewProvider(R.id.arrow)
    private val btnCancel: Button by viewProvider(R.id.btn_cancelar)
    private val btnAccept: Button by viewProvider(R.id.btn_aceptar)

    private val edtCover: EditText by viewProvider(R.id.caratula_text)
    private val edtName: EditText by viewProvider(R.id.name_input)
    private val edtArtist: EditText by viewProvider(R.id.artista_input)
    private val edtRelease: EditText by viewProvider(R.id.lanzamiento_input)
    private val edtGender: EditText by viewProvider(R.id.Genero_input)
    private val edtDiscography: EditText by viewProvider(R.id.casa_input)
    private val edtDescription: EditText by viewProvider(R.id.descripcion_input)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAlbumCreationBinding.inflate(inflater, container, false)
        return mBinding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showFloating()
        setUpListenerEvent()
    }


    private fun setUpListenerEvent() {
        arrowBack.setOnClickListener(this::backPressed)
        btnCancel.setOnClickListener(this::backPressed)
        btnAccept.setOnClickListener(this::createAlbum)
    }

    private fun backPressed(view: View) {
        val imm: InputMethodManager? =
            context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
        val navController = this.activity?.findNavController(R.id.nav_host_fragment)
        navController?.navigate(R.id.navigation_album)
    }


    private fun createAlbum(view: View) {
        val imm: InputMethodManager? =
            context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(view?.windowToken, 0)
        albumCreationViewModel.createAlbum(
            AlbumCreation(
                edtName.text.toString(),
                edtCover.text.toString(),
                edtRelease.text.toString(),
                edtDescription.text.toString(),
                edtGender.text.toString(),
                edtDiscography.text.toString()
            )
        )
            .observeData(this, ::showDetailResult)
            .observeErrorThrowable(this, ::observeErrorThrowable)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun showDetailResult(detailAlbum: JsonElement) {
        albumCreationViewModel.getAlbumsApi()
            .observeData(this, ::getAlbums)
            .observeErrorThrowable(this, ::observeErrorThrowable)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun observeErrorThrowable(error: Throwable) {
        val intent = Intent(this.activity, Maintenance::class.java)
        // start your next activity
        startActivity(intent)
    }

    private fun showFloating() {
        albumCreationViewModel.setStateFloating(false)
    }

    private fun getAlbums(albums: List<Album>) {
        Toast.makeText(this.context,"Album creado exitosamente",Toast.LENGTH_SHORT).show();
        albumCreationViewModel.setAlbumApi(albums)
    }
}