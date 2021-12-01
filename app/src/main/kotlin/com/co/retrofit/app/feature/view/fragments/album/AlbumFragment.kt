package com.co.retrofit.app.feature.view.fragments.album

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.co.base.retrofit.delegate.viewModelProvider
import com.co.retrofit.app.R
import com.co.retrofit.app.databinding.FragmentAlbumBinding
import com.co.retrofit.app.feature.view.activities.Maintenance
import com.co.retrofit.data.model.dto.Album
import com.co.retrofit.app.feature.view.adapter.album.AlbumAdapter
import com.co.retrofit.app.feature.viewmodel.album.AlbumViewModel

class AlbumFragment : Fragment() {


    private val albumViewModel by viewModelProvider(AlbumViewModel::class)
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
        adapter = AlbumAdapter(this@AlbumFragment) { item ->
            this.processItemAdapter(item);
        };
        // adapter instance is set to the recyclerview to inflate the items.
        mBinding!!.rvAlbumList.adapter = adapter

        albumViewModel.getAlbumCache()
            .observeSingleData(this, ::processAlbum)
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


    private fun processItemAdapter(album: Album){
        albumViewModel.saveSelectionItem(album)
        val navController = this.activity?.findNavController(R.id.nav_host_fragment)
        navController?.navigate(R.id.navigation_detail_album)
    }
    @Suppress("UNUSED_PARAMETER")
    private fun observeErrorThrowable(error: Throwable){
        val intent = Intent(this.activity, Maintenance::class.java)
        startActivity(intent)
    }

    private fun showFloating() {
        albumViewModel.setStateFloating(true)
    }
}