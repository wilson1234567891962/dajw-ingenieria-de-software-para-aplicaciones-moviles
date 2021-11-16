package com.co.retrofit.app.feature.view.fragments.album
import android.content.Context
import android.content.Intent
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
import com.co.base.retrofit.extension.hideLoader
import com.co.base.retrofit.extension.showLoader
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentAlbumDetailBinding
import com.co.retrofit.app.feature.view.activities.Maintenance
import com.co.retrofit.app.feature.view.adapter.album.AlbumAdapter
import com.co.retrofit.app.feature.view.adapter.album.DetailAlbumMusicAdapter
import com.co.retrofit.app.feature.viewmodel.album.AlbumDetailViewModel
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.DetailAlbum
import com.co.retrofit.data.model.dto.MusicAlbum


class AlbumDetailFragment : Fragment() {
    private var mBinding: FragmentAlbumDetailBinding? = null
    private val albumDetailViewModel by viewModelProvider(AlbumDetailViewModel::class)
    private val titleAlbum: TextView by viewProvider(R.id.title_album)
    private val artistAlbum: TextView by viewProvider(R.id.name_artist_album)
    private val releaseAlbum: TextView by viewProvider(R.id.release_date_album)
    private val genereAlbum: TextView by viewProvider(R.id.gnere_album)
    private val recordAlbum: TextView by viewProvider(R.id.record_album)
    private val description: EditText by viewProvider(R.id.description)
    private lateinit var adapterMusic: DetailAlbumMusicAdapter
    private val back: View by viewProvider(R.id.back_detail_album)

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
        albumDetailViewModel.getAlbumSelection()
            .observeSingleData(this, ::callServiceApi)
            .observeErrorThrowable(this, ::observeErrorThrowable)
        setUpListenerEvent()
        showFloating()
    }

    private fun setUpListenerEvent() {
        back.setOnClickListener(this::backPressed)
    }

    private fun backPressed(view: View) {
        val navController = this.activity?.findNavController(R.id.nav_host_fragment)
        navController?.navigate(R.id.navigation_album)
    }

    private fun callServiceApi(album: Album){
//        this.activity?.showLoader()
        albumDetailViewModel.getAlbumDetailApi(album)
            .observeSingleData(this, ::showDetailResult)
            .observeErrorThrowable(this, ::observeErrorThrowable)

    }

    private fun showDetailResult(detailAlbum: DetailAlbum){
        titleAlbum.text = "${detailAlbum.title}"
        artistAlbum.text = "Artista: ${detailAlbum.name.first().name}"
        releaseAlbum.text = "Lanzamiento: ${detailAlbum.release}"
        genereAlbum.text = "Genero: ${detailAlbum.genre}"
        recordAlbum.text = "Casa discográfica: ${detailAlbum.recordLabel}"
        description.setText(detailAlbum.description)
        this.showListMusic(detailAlbum.music)
//        this.activity?.hideLoader()
    }

    private fun showListMusic(music: List<MusicAlbum>) {
        // Set the LayoutManager that this RecyclerView will use.
        mBinding!!.rvAlbumDetailList.layoutManager =
            GridLayoutManager(requireActivity(), 1)
        // Adapter class is initialized and list is passed in the param.
        adapterMusic = DetailAlbumMusicAdapter(this@AlbumDetailFragment)
        // adapter instance is set to the recyclerview to inflate the items.
        mBinding!!.rvAlbumDetailList.adapter = adapterMusic
        adapterMusic.albumMusicList(music)
    }

    private fun showFloating() {
        albumDetailViewModel.setStateFloating(true)
    }

    private fun observeErrorThrowable(error: Throwable){
 //       this.activity?.hideLoader()
        val intent = Intent(this.activity, Maintenance::class.java)
        // start your next activity
        startActivity(intent)
    }

}