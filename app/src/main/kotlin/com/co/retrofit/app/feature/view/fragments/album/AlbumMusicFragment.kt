package com.co.retrofit.app.feature.view.fragments.album

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.base.retrofit.delegate.viewProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.feature.view.activities.Maintenance
import com.co.retrofit.app.feature.viewmodel.album.AlbumMusicViewModel
import com.co.retrofit.data.model.dto.Music
import com.google.gson.JsonElement
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import com.co.retrofit.app.databinding.FragmentAddMusicBinding
import com.co.retrofit.data.model.dto.Album


class AlbumMusicFragment : Fragment() {
    private var mBinding: FragmentAddMusicBinding? = null
    private val back: View by viewProvider(R.id.back_add_music)
    private val btnCancel: View by viewProvider(R.id.btn_cancelar)
    private val btnAccept: View by viewProvider(R.id.btn_aceptar)
    private val edtName: EditText by viewProvider(R.id.text_name)
    private val edtDuration: EditText by viewProvider(R.id.text_duration)
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
        btnCancel.setOnClickListener(this::backPressed)
        btnAccept.setOnClickListener(this::addMusic)
    }
    @Suppress("UNUSED_PARAMETER")
    private fun backPressed(view: View) {
        val navController = this.activity?.findNavController(R.id.nav_host_fragment)
        navController?.navigate(R.id.navigation_detail_album)
    }
    @Suppress("UNUSED_PARAMETER")
    private fun addMusic(view: View) {
        albumMusicViewModel.getAlbumSelection()
            .observeSingleData(this, ::getIdAlbum)
            .observeErrorThrowable(this, ::observeErrorThrowable)

    }

    @Suppress("UNUSED_PARAMETER")
    private fun getIdAlbum(album: Album){
        albumMusicViewModel.addMusic(Music(edtName.text.toString(), edtDuration.text.toString()),album.id)
            .observeData(this, ::showDetailResult)
            .observeErrorThrowable(this, ::observeErrorThrowable)
    }


    @Suppress("UNUSED_PARAMETER")
    private fun showDetailResult(detailAlbum: JsonElement){
        val imm: InputMethodManager? =
            context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(view?.windowToken, 0)
       Toast.makeText(this.context, "Se agrego con exito ", Toast.LENGTH_SHORT).show()
    }

    @Suppress("UNUSED_PARAMETER")
    private fun observeErrorThrowable(error: Throwable){
        val intent = Intent(this.activity, Maintenance::class.java)
        // start your next activity
        startActivity(intent)
    }

}
