package com.co.retrofit.app.feature.view.fragments.album


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.base.retrofit.delegate.viewProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentAlbumDetailBinding
import com.co.retrofit.app.feature.view.activities.Maintenance
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
        // Set the LayoutManager that this RecyclerView will use.
        mBinding!!.rvAlbumDetailList.layoutManager =
            GridLayoutManager(requireActivity(), 1)
        // Adapter class is initialized and list is passed in the param.
        adapterMusic = DetailAlbumMusicAdapter(this@AlbumDetailFragment)
        // adapter instance is set to the recyclerview to inflate the items.
        mBinding!!.rvAlbumDetailList.adapter = adapterMusic
        albumDetailViewModel.getAlbumSelection()
            .observeSingleData(this, ::callServiceApi)
            .observeErrorThrowable(this, ::observeErrorThrowable)
        setUpListenerEvent()
        showFloating()
    }

    private fun setUpListenerEvent() {
        back.setOnClickListener(this::backPressed)
    }
    @Suppress("UNUSED_PARAMETER")
    private fun backPressed(view: View) {
        val navController = this.activity?.findNavController(R.id.nav_host_fragment)
        navController?.navigate(R.id.navigation_album)
    }

    private fun callServiceApi(album: Album){
        albumDetailViewModel.getAlbumDetailApi(album)
            .observeSingleData(this, ::showDetailResult)
            .observeErrorThrowable(this, ::observeErrorThrowable)

    }

    private fun showDetailResult(detailAlbum: DetailAlbum){
        titleAlbum.text = "${detailAlbum.title}"
        artistAlbum.text = "Artista: " + if(detailAlbum.name.isNotEmpty()) detailAlbum.name?.first().name else ""
        releaseAlbum.text = "Lanzamiento: ${detailAlbum.release}"
        genereAlbum.text = "Genero: ${detailAlbum.genre}"
        recordAlbum.text = "Casa discográfica: ${detailAlbum.recordLabel}"
        description.setText(detailAlbum.description)
        this.showListMusic(detailAlbum.music)
//        this.activity?.hideLoader()
    }

    private fun showListMusic(music: List<MusicAlbum>) {
        adapterMusic.albumMusicList(music)
    }

    private fun showFloating() {
        albumDetailViewModel.setStateFloating(true)
    }
    @Suppress("UNUSED_PARAMETER")
    private fun observeErrorThrowable(error: Throwable){
        val intent = Intent(this.activity, Maintenance::class.java)
        startActivity(intent)
    }

}