package com.co.retrofit.app.feature.view.fragments.album
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.base.retrofit.delegate.viewProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentAddMusicBinding
import com.co.retrofit.app.databinding.FragmentAlbumDetailBinding
import com.co.retrofit.app.feature.view.adapter.album.AlbumAdapter
import com.co.retrofit.app.feature.view.adapter.album.DetailAlbumMusicAdapter
import com.co.retrofit.app.feature.viewmodel.album.AlbumDetailViewModel
import com.co.retrofit.app.feature.viewmodel.album.AlbumMusicViewModel
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.DetailAlbum
import com.co.retrofit.data.model.dto.MusicAlbum


class AlbumMusicFragment : Fragment() {
    private var mBinding: FragmentAddMusicBinding? = null
    private val back: View by viewProvider(R.id.back_add_music)
    private val albumMusicViewModel by viewModelProvider(AlbumMusicViewModel::class)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAddMusicBinding.inflate(inflater, container, false)
        return mBinding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListenerEvent()
        showFloating()
    }

    private fun showFloating() {
        albumMusicViewModel.setStateFloating(false)
    }

    private fun setUpListenerEvent() {
        back.setOnClickListener(this::backPressed)
    }

    private fun backPressed(view: View) {
        val navController = this.activity?.findNavController(R.id.nav_host_fragment)
        navController?.navigate(R.id.navigation_detail_album)
    }

    private fun observeErrorThrowable(){
        Log.d("Fue resultado exitoso", "")
    }

    private fun observeErrorThrowable(error: Throwable){
        Log.d("Fue resultado exitoso", error.toString())
    }

}