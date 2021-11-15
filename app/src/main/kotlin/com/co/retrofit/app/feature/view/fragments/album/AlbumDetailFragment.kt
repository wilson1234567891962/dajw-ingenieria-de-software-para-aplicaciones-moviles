package com.co.retrofit.app.feature.view.fragments.album
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.base.retrofit.delegate.viewProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentAlbumDetailBinding
import com.co.retrofit.app.feature.viewmodel.album.AlbumDetailViewModel
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.data.model.dto.DetailAlbum


class AlbumDetailFragment : Fragment() {
    private var mBinding: FragmentAlbumDetailBinding? = null
    private val albumDetailViewModel by viewModelProvider(AlbumDetailViewModel::class)
    private val titleAlbum: TextView by viewProvider(R.id.title_album)
    private val artistAlbum: TextView by viewProvider(R.id.name_artist_album)
    private val releaseAlbum: TextView by viewProvider(R.id.release_date_album)
    private val genereAlbum: TextView by viewProvider(R.id.gnere_album)
    private val recordAlbum: TextView by viewProvider(R.id.record_album)
    private val description: EditText by viewProvider(R.id.description)

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
            .observeError(this, ::observeErrorThrowable)
            .observeErrorThrowable(this, ::observeErrorThrowable)
    }

    private fun callServiceApi(album: Album){
        albumDetailViewModel.getAlbumDetailApi(album)
            .observeSingleData(this, ::showDetailResult)
            .observeError(this, ::observeErrorThrowable)
            .observeErrorThrowable(this, ::observeErrorThrowable)

    }

    private fun showDetailResult(detailAlbum: DetailAlbum){
        titleAlbum.text = "${detailAlbum.name}"
        artistAlbum.text = "Artista: ${detailAlbum.name}"
        releaseAlbum.text = "Lanzamiento: ${detailAlbum.release}"
        genereAlbum.text = "Genero: ${detailAlbum.genre}"
        recordAlbum.text = "Casa discográfica: ${detailAlbum.recordLabel}"
        description.setText(detailAlbum.description)
    }

    private fun observeErrorThrowable(){
        Log.d("Fue resultado exitoso", "")
    }

    private fun observeErrorThrowable(error: Throwable){
        Log.d("Fue resultado exitoso", error.toString())
    }

}