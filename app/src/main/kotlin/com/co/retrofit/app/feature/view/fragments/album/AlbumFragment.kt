package com.co.retrofit.app.feature.view.fragments.album
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.base.retrofit.extension.hideLoader
import com.co.base.retrofit.extension.showLoader
import com.co.retrofit.app.databinding.FragmentAlbumBinding
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.app.feature.view.adapter.AlbumAdapter
import com.co.retrofit.app.feature.viewmodel.AlbumViewModel

class AlbumFragment : Fragment() {


    private val homeViewModel by viewModelProvider(AlbumViewModel::class)
    private var mBinding: FragmentAlbumBinding? = null
    private lateinit var adapter: AlbumAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAlbumBinding.inflate(inflater, container, false)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Add an observer on the LiveData returned by getFavoriteDishesList.
         * The onChanged() method fires when the observed data changes and the activity is in the foreground.
         */


        // Set the LayoutManager that this RecyclerView will use.
        mBinding!!.rvAlbumList.layoutManager =
            GridLayoutManager(requireActivity(), 2)
        // Adapter class is initialized and list is passed in the param.
        adapter = AlbumAdapter(this@AlbumFragment)
        // adapter instance is set to the recyclerview to inflate the items.
        mBinding!!.rvAlbumList.adapter = adapter


        homeViewModel.getAlbumCache()
            .observeSingleData(this, ::processAlbum)
            .observeError(this, ::observeErrorThrowable)
            .observeErrorThrowable(this, ::observeErrorThrowable)
         showFloating()
    }

    private fun processAlbum(albums: List<Album>) {
        if (albums.isNotEmpty()) {
            mBinding!!.rvAlbumList.visibility = View.VISIBLE
            mBinding!!.tvAlbumAvailable.visibility = View.GONE

            adapter.albumList(albums)
        } else {
            mBinding!!.rvAlbumList.visibility = View.GONE
            mBinding!!.tvAlbumAvailable.visibility = View.VISIBLE
        }
    }

    private fun observeErrorThrowable(){
        Log.d("Fue resultado exitoso", "")
    }

    private fun observeErrorThrowable(error: Throwable){
        Log.d("Fue resultado exitoso", error.toString())
    }


    private fun showFloating() {
        homeViewModel.setStateFloating(true)
    }
}