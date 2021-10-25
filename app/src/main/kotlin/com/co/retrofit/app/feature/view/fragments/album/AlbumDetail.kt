package com.co.retrofit.app.feature.view.fragments.album

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.base.retrofit.delegate.viewProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentAlbumCreationBinding
import com.co.retrofit.app.databinding.FragmentAlbumDetailBinding
import com.co.retrofit.app.feature.viewmodel.album.AlbumCreationViewModel


class AlbumDetail: Fragment() {

    private val albumCreationViewModel by viewModelProvider(AlbumCreationViewModel::class)
    private var mBinding: FragmentAlbumDetailBinding? = null
    private val arrowBack: ImageView by viewProvider(R.id.arrow)
    private val btnCancelar: Button by viewProvider(R.id.btn_cancelar)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAlbumDetailBinding.inflate(inflater, container, false)
        return mBinding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showFloating()
        setUpListenerEvent()
    }


    private fun setUpListenerEvent() {
        arrowBack.setOnClickListener(this::backPressed)
    }

    private fun backPressed(view: View) {
        val imm: InputMethodManager? = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
        val navController = this.activity?.findNavController(R.id.nav_host_fragment)
        navController?.navigate(R.id.navigation_album)
    }


    private fun showFloating() {
        albumCreationViewModel.setStateFloating(false)
    }

}