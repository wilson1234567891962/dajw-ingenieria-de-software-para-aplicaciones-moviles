package com.co.retrofit.app.feature.view.fragments.album
import android.os.Bundle
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
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.view.adapter.AlbumAdapter
import com.co.retrofit.app.feature.viewmodel.AlbumViewModel

class AlbumFragment : Fragment() {


    private val homeViewModel by viewModelProvider(AlbumViewModel::class)
    private var mBinding: FragmentAlbumBinding? = null


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
        val adapter = AlbumAdapter(this@AlbumFragment)
        // adapter instance is set to the recyclerview to inflate the items.
        mBinding!!.rvAlbumList.adapter = adapter
        this.activity?.showLoader()
        homeViewModel.refreshDataFromNetwork()
        homeViewModel.albums.observe(viewLifecycleOwner, Observer<List<Album>> {
            it.apply {
                if (it.isNotEmpty()) {
                    mBinding!!.rvAlbumList.visibility = View.VISIBLE
                    mBinding!!.tvAlbumAvailable.visibility = View.GONE

                    adapter.albumList(it)
                } else {
                    mBinding!!.rvAlbumList.visibility = View.GONE
                    mBinding!!.tvAlbumAvailable.visibility = View.VISIBLE
                }
            }
            this.activity?.hideLoader()
        })
         showFloating()
    }

    private fun showFloating() {
        homeViewModel.setStateFloating(true)
    }
}